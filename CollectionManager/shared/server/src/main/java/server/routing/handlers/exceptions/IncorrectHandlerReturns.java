package server.routing.handlers.exceptions;

/**
 * Exception thrown when method annotated with {@code server.routing.handlers.Handler}
 * has returns that does not match single {@code Response} parameter.
 */
public class IncorrectHandlerReturns extends RuntimeException {
}
