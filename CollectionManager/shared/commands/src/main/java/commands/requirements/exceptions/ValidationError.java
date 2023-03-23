package commands.requirements.exceptions;

import commands.Messages.Requirements;

/**
 * Throw by Validator when cannot convert taken value to target type
 */
public class ValidationError extends Exception {
    public ValidationError(Object value, Class<?> outputType, String message) {
        super(Requirements.VALIDATION_ERROR.formatted(value, outputType, message));
    }
}
