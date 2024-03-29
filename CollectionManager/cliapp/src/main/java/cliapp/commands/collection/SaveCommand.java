package cliapp.commands.collection;

import java.io.FileNotFoundException;

import cliapp.TextsManager;
import commands.OutputChannel;
import commands.exceptions.ExecutionError;
import commands.requirements.RequirementsPipeline;
import humandeque.manager.CollectionManager;
import humandeque.manager.exceptions.CollectionSaveError;
import humandeque.manager.exceptions.ManipulationError;
import textlocale.text.TextSupplier;

/**
 * A command that saves the collection to a file.
 */
public class SaveCommand extends CollectionCommand {
    static TextSupplier ts = TextsManager.getTexts().getPackage("commands.collection")::getText;

    /**
     * Constructs a SaveCommand object with a collection manager.
     *
     * @param collectionManager the collection manager to be used by this command.
     */
    public SaveCommand(CollectionManager collectionManager) {
        super(ts.t("SaveCommand.Name"),
                ts.t("SaveCommand.Description"),
                collectionManager);
    }

    /**
     * Saves the collection and displays a message to the output channel.
     *
     * @param pipeline the pipeline of requirements to be used by this command.
     * @param output   the output channel where messages will be displayed.
     * @throws ExecutionError if there was an error while saving the collection.
     */
    @Override
    public void execute(RequirementsPipeline pipeline, OutputChannel output) throws ExecutionError {
        try {
            collectionManager.save();
            output.putString(ts.t("SaveCommand.Success"));
        } catch (CollectionSaveError e) {
            if (e.getCause() instanceof FileNotFoundException) {
                throw new ExecutionError(ts.t("SaveCommand.FileNotFound"));
            } else {
                throw new ExecutionError(ts.t("SaveCommand.SaveError"));
            }
        } catch (ManipulationError e) {
            throw new ExecutionError(e.getMessage());
        }
    }
}
