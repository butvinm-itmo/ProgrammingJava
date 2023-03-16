package cliapp;

import java.util.ResourceBundle;

/**
 * That class provides handy static access for project text resources
 */
public class Messages {
    /**
     * cliapp.commands.collection.requirements
     */
    public static class ElementRequirements {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.element");

        public static final String ID = BUNDLE.getString("Id");
        public static final String ID_DESCR = BUNDLE.getString("IdDescr");
        public static final String ID_NOT_POSITIVE = BUNDLE.getString("IdNotPositive");
        public static final String ID_NOT_EXISTS = BUNDLE.getString("IdNotExists");
        public static final String NAME = BUNDLE.getString("Name");
        public static final String NAME_DESCR = BUNDLE.getString("NameDescr");
        public static final String COORDINATE_X = BUNDLE.getString("CoordinateX");
        public static final String COORDINATE_X_DESCR = BUNDLE.getString("CoordinateXDescr");
        public static final String COORDINATE_X_VALIDATION_ERROR = BUNDLE.getString("CoordinateXValidationError");
        public static final String COORDINATE_Y = BUNDLE.getString("CoordinateY");
        public static final String COORDINATE_Y_DESCR = BUNDLE.getString("CoordinateYDescr");
        public static final String COORDINATE_Y_VALIDATION_ERROR = BUNDLE.getString("CoordinateYValidationError");
        public static final String REAL_HERO = BUNDLE.getString("RealHero");
        public static final String REAL_HERO_DESCR = BUNDLE.getString("RealHeroDescr");
        public static final String HAS_TOOTHPICK = BUNDLE.getString("HasToothpick");
        public static final String HAS_TOOTHPICK_DESCR = BUNDLE.getString("HasToothpickDescr");
        public static final String IMPACT_SPEED = BUNDLE.getString("ImpactSpeed");
        public static final String IMPACT_SPEED_DESCR = BUNDLE.getString("ImpactSpeedDescr");
        public static final String SOUNDTRACK_NAME = BUNDLE.getString("SoundtrackName");
        public static final String SOUNDTRACK_NAME_DESCR = BUNDLE.getString("SoundtrackNameDescr");
        public static final String MINUTES_OF_WAITING = BUNDLE.getString("MinutesOfWaiting");
        public static final String MINUTES_OF_WAITING_DESCR = BUNDLE.getString("MinutesOfWaitingDescr");
        public static final String MOOD = BUNDLE.getString("Mood");
        public static final String MOOD_DESCR = BUNDLE.getString("MoodDescr");
        public static final String MOOD_BY_NUMBER_NOT_EXISTS = BUNDLE.getString("MoodByNumberNotExists");
        public static final String MOOD_BY_NAME_NOT_EXISTS = BUNDLE.getString("MoodByNameNotExists");
        public static final String MOOD_VALIDATION_ERROR = BUNDLE.getString("MoodValidationError");
        public static final String CAR_NAME = BUNDLE.getString("CarName");
        public static final String CAR_NAME_DESCR = BUNDLE.getString("CarNameDescr");
    }

    /**
     * cliapp.commands.collection InfoCommand
     */
    public static class InfoCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("InfoName");
        public static final String DESCRIPTION = BUNDLE.getString("InfoDescription");
        public static final String SUCCESS = BUNDLE.getString("InfoSuccess");
        public static final String TYPE = BUNDLE.getString("InfoType");
        public static final String INIT_TIME = BUNDLE.getString("InfoInitTime");
        public static final String ELEMENTS_COUNT = BUNDLE.getString("InfoElementsCount");
        public static final String ERROR = BUNDLE.getString("InfoError");
    }

    /**
     * cliapp.commands.collection ShowCommand
     */
    public static class ShowCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("ShowName");
        public static final String DESCRIPTION = BUNDLE.getString("ShowDescription");
        public static final String SUCCESS = BUNDLE.getString("ShowSuccess");
        public static final String ERROR = BUNDLE.getString("ShowError");
    }

    /**
     * cliapp.commands.collection AddElementCommand
     */
    public static class AddElementCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("AddName");
        public static final String DESCRIPTION = BUNDLE.getString("AddDescription");
        public static final String SUCCESS = BUNDLE.getString("AddSuccess");
        public static final String ERROR = BUNDLE.getString("AddError");
    }

    /**
     * cliapp.commands.collection UpdateElementCommand
     */
    public static class UpdateElementCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("UpdateName");
        public static final String DESCRIPTION = BUNDLE.getString("UpdateDescription");
        public static final String SUCCESS = BUNDLE.getString("UpdateSuccess");
        public static final String ERROR = BUNDLE.getString("UpdateError");
    }

    /**
     * cliapp.commands.collection RemoveByIdCommand
     */
    public static class RemoveByIdCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("RemoveByIdName");
        public static final String DESCRIPTION = BUNDLE.getString("RemoveByIdDescription");
        public static final String SUCCESS = BUNDLE.getString("RemoveByIdSuccess");
        public static final String ERROR = BUNDLE.getString("RemoveByIdError");
    }

    /**
     * cliapp.commands.collection ClearCommand
     */
    public static class ClearCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("ClearName");
        public static final String DESCRIPTION = BUNDLE.getString("ClearDescription");
        public static final String SUCCESS = BUNDLE.getString("ClearSuccess");
        public static final String ERROR = BUNDLE.getString("ClearError");
    }

    /**
     * cliapp.commands.collection SaveCommand
     */
    public static class SaveCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("SaveName");
        public static final String DESCRIPTION = BUNDLE.getString("SaveDescription");
        public static final String SUCCESS = BUNDLE.getString("SaveSuccess");
        public static final String ERROR = BUNDLE.getString("SaveError");
    }

    /**
     * cliapp.commands.collection RemoveFirstCommand
     */
    public static class RemoveFirstCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("RemoveFirstName");
        public static final String DESCRIPTION = BUNDLE.getString("RemoveFirstDescription");
        public static final String SUCCESS = BUNDLE.getString("RemoveFirstSuccess");
        public static final String ERROR = BUNDLE.getString("RemoveFirstError");
    }

    /**
     * cliapp.commands.collection HeadCommand
     */
    public static class HeadCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("HeadName");
        public static final String DESCRIPTION = BUNDLE.getString("HeadDescription");
        public static final String SUCCESS = BUNDLE.getString("HeadSuccess");
        public static final String ERROR = BUNDLE.getString("HeadError");
    }

    /**
     * cliapp.commands.collection AverageOfImpactSpeedCommand
     */
    public static class AverageOfImpactSpeedCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("AverageOfImpactSpeedName");
        public static final String DESCRIPTION = BUNDLE
                .getString("AverageOfImpactSpeedDescription");
        public static final String SUCCESS = BUNDLE.getString("AverageOfImpactSpeedSuccess");
        public static final String ERROR = BUNDLE.getString("AverageOfImpactSpeedError");
    }

    /**
     * cliapp.commands.collection FilterBySoundtrackNameCommand
     */
    public static class FilterBySoundtrackNameCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("FilterBySoundtrackNameName");
        public static final String DESCRIPTION = BUNDLE.getString("FilterBySoundtrackNameDescription");
        public static final String SUCCESS = BUNDLE.getString("FilterBySoundtrackNameSuccess");
        public static final String ERROR = BUNDLE.getString("FilterBySoundtrackNameError");
    }

    /**
     * cliapp.commands.collection PrintDescendingCommand
     */
    public static class PrintDescendingCommand {
        private static final ResourceBundle BUNDLE = ResourceBundle
                .getBundle("cliapp.commands.collection.commands");

        public static final String NAME = BUNDLE.getString("PrintDescendingName");
        public static final String DESCRIPTION = BUNDLE.getString("PrintDescendingDescription");
        public static final String SUCCESS = BUNDLE.getString("PrintDescendingSuccess");
        public static final String ERROR = BUNDLE.getString("PrintDescendingError");
    }
}