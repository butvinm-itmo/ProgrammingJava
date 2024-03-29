package cliapp.collection;

import java.io.Serializable;
import java.util.Map;

import adapter.Adapter;
import adapter.exceptions.ReceiveResponseFailed;
import adapter.exceptions.SendRequestFailed;
import adapter.exceptions.SocketInitFailed;
import cliapp.TextsManager;
import collections.service.api.StatusCodes;
import humandeque.HumanDeque;
import humandeque.TextResources.Manager.ExceptionsResources;
import humandeque.manager.CollectionManager;
import humandeque.manager.exceptions.CollectionLoadError;
import humandeque.manager.exceptions.CollectionSaveError;
import humandeque.manager.exceptions.ElementAlreadyExistsError;
import humandeque.manager.exceptions.ElementNotExistsError;
import humandeque.manager.exceptions.EmptyCollectionError;
import humandeque.manager.exceptions.ManipulationError;
import lombok.SneakyThrows;
import models.Human;
import server.responses.Response;
import textlocale.text.TextSupplier;

/**
 * That manager execute all manipulations on client and store collection in
 * local csv file
 */
public class RemoteManager extends CollectionManager {
    static TextSupplier ts = TextsManager.getTexts().getPackage("collection")::getText;

    /**
     * Adapter for send requests to collections service
     */
    private Adapter serviceAdapter;

    /**
     * Create new RemoteManager and load collection from collections service
     *
     * @param serviceAdapter Adapter for send requests to collections service
     * @param userId         user id
     * @throws CollectionLoadError if collection can't be loaded
     */
    public RemoteManager(Adapter serviceAdapter) throws CollectionLoadError, ManipulationError {
        this.serviceAdapter = serviceAdapter;
        load();
    }

    @Override
    @SneakyThrows(ManipulationError.class)
    public void add(Human element) throws ElementAlreadyExistsError, ManipulationError {
        Map<String, Serializable> data = Map.of("human", element);
        Response response = sendRequestOrFail("collections.add", data);
        if (response.getCode() == StatusCodes.ELEMENT_ALREADY_EXISTS) {
            throw new ElementAlreadyExistsError(element.getId());
        } else if (!response.getOk()) {
            throw new ManipulationError(response.getMessage());
        }
        this.collection.add(element);
    }

    @Override
    public void update(Human element) throws ElementNotExistsError, ManipulationError {
        Map<String, Serializable> data = Map.of("human", element);
        Response response = sendRequestOrFail("collections.update", data);
        if (response.getCode() == StatusCodes.ELEMENT_NOT_EXISTS) {
            throw new ElementNotExistsError(element.getId());
        } else if (!response.getOk()) {
            throw new ManipulationError(response.getMessage());
        }
        Human human = getElementById(element.getId());
        collection.remove(human);
        collection.add(element);
    }

    @Override
    public void remove(long id) throws ElementNotExistsError, ManipulationError {
        Map<String, Serializable> data = Map.of("id", id);
        Response response = sendRequestOrFail("collections.remove", data);
        if (response.getCode() == StatusCodes.ELEMENT_NOT_EXISTS) {
            throw new ElementNotExistsError(id);
        } else if (!response.getOk()) {
            throw new ManipulationError(response.getMessage());
        }
        Human human = getElementById(id);
        collection.remove(human);
    }

    @Override
    public void clear() throws ManipulationError {
        Map<String, Serializable> data = Map.of();
        Response response = sendRequestOrFail("collections.clear", data);
        if (!response.getOk()) {
            throw new ManipulationError(response.getMessage());
        }
        collection.clear();
    }

    @Override
    public void removeFirst() throws EmptyCollectionError, ManipulationError {
        Map<String, Serializable> data = Map.of();
        Response response = sendRequestOrFail("collections.removeFirst", data);
        if (!response.getOk()) {
            throw new ManipulationError(response.getMessage());
        }
        Human removedHuman = (Human) response.getData().get("human");
        collection.remove(removedHuman);
    }

    @Override
    public void removeLast() throws EmptyCollectionError, ManipulationError {
        Map<String, Serializable> data = Map.of();
        Response response = sendRequestOrFail("collections.removeLast", data);
        if (!response.getOk()) {
            throw new ManipulationError(response.getMessage());
        }
        Human removedHuman = (Human) response.getData().get("human");
        collection.remove(removedHuman);
    }

    @Override
    public void load() throws CollectionLoadError, ManipulationError {
        Map<String, Serializable> data = Map.of();
        Response response = sendRequestOrFail("collections.get", data);
        if (response.getOk()) {
            HumanDeque loadedCollection = (HumanDeque) response.getData().get("collection");
            this.collection = loadedCollection;
        } else {
            throw new CollectionLoadError(ExceptionsResources.COLLECTION_LOAD_ERROR);
        }
    }

    @Override
    public void save() throws CollectionSaveError, ManipulationError {
        Map<String, Serializable> data = Map.of("collection", collection);
        Response response = sendRequestOrFail("collections.save", data);
        if (response.getCode() == StatusCodes.CANNOT_SAVE_COLLECTION) {
            throw new CollectionSaveError(ExceptionsResources.COLLECTION_SAVE_ERROR);
        } else if (!response.getOk()) {
            throw new ManipulationError(response.getMessage());
        }
    }

    /**
     * Sends request to server and returns.
     * If something goes wrong, throws ManipulationError.
     *
     * @param method name of method to call
     * @param data   data to send
     * @return response from server
     * @throws ManipulationError if something goes wrong
     */
    private Response sendRequestOrFail(String method, Map<String, Serializable> data) throws ManipulationError {
        try {
            return serviceAdapter.triggerServer(method, data);
        } catch (SocketInitFailed | SendRequestFailed | ReceiveResponseFailed e) {
            throw new ManipulationError(ts.t("remotemanager.FailedRequest"));
        }
    }
}
