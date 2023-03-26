package cliapp.utils;

/**
 * Used for coloring text in console.
 */
public class TextColor {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String BLACK = "\u001B[30m";

    public static final String RED = "\u001B[31m";

    public static final String GREEN = "\u001B[32m";

    public static final String YELLOW = "\u001B[33m";

    public static final String BLUE = "\u001B[34m";

    public static final String PURPLE = "\u001B[35m";

    public static final String CYAN = "\u001B[36m";

    public static final String WHITE = "\u001B[37m";

    public static String getColoredString(String text, String color) {
        return color + text + ANSI_RESET;
    }
}