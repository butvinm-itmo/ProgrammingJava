package cliapp.commands.collection;

import cliapp.TextsManager;
import commands.OutputChannel;
import commands.exceptions.ExecutionError;
import commands.requirements.RequirementsPipeline;
import commands.requirements.exceptions.RequirementAskError;
import humandeque.manager.CollectionManager;
import humandeque.manager.exceptions.ElementAlreadyExistsError;
import humandeque.manager.exceptions.ManipulationError;
import models.Car;
import models.Coordinates;
import models.Human;
import models.Mood;
import textlocale.text.TextSupplier;

/**
 * Command that adds a new human element to the collection.
 */
public class AddElementCommand extends CollectionCommand {
    static TextSupplier ts = TextsManager.getTexts().getPackage("commands.collection")::getText;

    /**
     * Constructor for AddElementCommand.
     *
     * @param collectionManager instance of CollectionManager class.
     */
    public AddElementCommand(CollectionManager collectionManager) {
        super(ts.t("AddElementCommand.Name"),
                ts.t("AddElementCommand.Description"),
                collectionManager);
    }

    /**
     * Asks the user for input to create a new {@link Human} object.
     *
     * @param pipeline the requirements pipeline to ask for input requirements
     * @param output   the output channel to write the input prompts and messages to
     * @return a {@link Human} object created with the input from the user
     * @throws RequirementAskError if there is an error asking for input
     *                             requirements
     */
    private Human askHuman(RequirementsPipeline pipeline, OutputChannel output)
            throws RequirementAskError {
        Human.HumanBuilder humanBuilder = Human.builder();

        humanBuilder.name(pipeline.askRequirement(nameRequirement));

        Coordinates.CoordinatesBuilder coordinatesBuilder = Coordinates.builder();
        coordinatesBuilder.x(pipeline.askRequirement(coordinateXRequirement));
        coordinatesBuilder.y(pipeline.askRequirement(coordinateYRequirement));

        humanBuilder.coordinates(coordinatesBuilder.build());

        humanBuilder.realHero(pipeline.askRequirement(realHeroRequirement));

        humanBuilder.hasToothpick(pipeline.askRequirement(hasToothpickRequirement));

        humanBuilder.impactSpeed(pipeline.askRequirement(impactSpeedRequirement));

        humanBuilder.soundtrackName(pipeline.askRequirement(soundtrackRequirement));

        humanBuilder.minutesOfWaiting(pipeline.askRequirement(minutesOfWaitingRequirement));

        String moods = "";
        for (int i = 0; i < Mood.values().length - 1; i++) {
            moods += i + " - " + Mood.values()[i] + System.lineSeparator();
        }
        moods += (Mood.values().length - 1) + " - " + Mood.values()[Mood.values().length - 1];

        String moodTitle = TextsManager.getTexts().getPackage("commands.requirements").getText("MoodRequirement.Title");
        output.putString(moodTitle + System.lineSeparator() + moods);
        humanBuilder.mood(pipeline.askRequirement(moodRequirement));

        Car car = new Car(pipeline.askRequirement(carNameRequirement));
        humanBuilder.car(car);

        return humanBuilder.build();
    }

    /**
     * Add a human element to the collection.
     *
     * @param pipeline RequirementsPipeline instance.
     * @param output   OutputChannel instance.
     * @throws ExecutionError when there is an error while executing.
     */
    @Override
    public void execute(RequirementsPipeline pipeline, OutputChannel output) throws ExecutionError {
        try {
            Human human = askHuman(pipeline, output);
            try {
                collectionManager.add(human);
                output.putString(ts.t("AddElementCommand.Success"));
            } catch (ElementAlreadyExistsError | ManipulationError e) {
                throw new ExecutionError(e.getMessage());
            }
        } catch (RequirementAskError e) {
            throw new ExecutionError(e.getMessage());
        }
    }
}
