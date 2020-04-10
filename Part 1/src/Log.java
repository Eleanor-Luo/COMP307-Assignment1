public class Log {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ERROR_COLOR = "\u001B[31m";
    private static final String COMPLETE_COLOR = "\u001B[32m";
    private static final String WARNING_COLOR = "\u001B[33m";
    private static final String LOG_COLOR = "\u001B[37m";

    // public static final String ANSI_GREEN = "\u001B[32m";

    public static void error(String msg) {
        print(msg, ERROR_COLOR);
    }

    public static void warning(String msg) {
        print(msg, WARNING_COLOR);
    }

    public static void complete(String msg) {
        print(msg, COMPLETE_COLOR);
    }

    public static void log(String msg) {
        print(msg, LOG_COLOR);
    }

    private static void print(String msg, String color) {
        System.out.println(color + msg + ANSI_RESET);
    }
}