package test;

import test.ComparisonFailure;

import java.io.OutputStream;
import java.io.PrintStream;

public class Assert {

    public static final String green = "\u001B[32m";
    public static final String reset = "\u001B[0m";
    public static PrintStream originalOut = System.out;
    public static PrintStream actualOut = originalOut;
    public static PrintStream newOut = new PrintStream(new OutputStream() {
        public void write(int b) {}
    });

    private static boolean isEquals(Object expected, Object actual) {
        return expected.equals(actual);
    }

    private static boolean equalsRegardingNull(Object expected, Object actual) {
        if (expected == null) {
            return actual == null;
        } else {
            return isEquals(expected, actual);
        }
    }

    public static void assertEquals(String message, Object expected, Object actual) throws ComparisonFailure {
        if (!equalsRegardingNull(expected, actual)) {
            if (expected instanceof String && actual instanceof String) {
                String cleanMessage = message == null ? "" : message;
                throw new ComparisonFailure(cleanMessage, expected, actual);
            } else if (expected.getClass().getName().equals(actual.getClass().getName())) {
                String cleanMessage = message == null ? "" : message;
                throw new ComparisonFailure(cleanMessage, expected, actual);
            } else {
                String expectedString = String.valueOf(expected);
                String actualString = String.valueOf(actual);
                String cleanMessage = message == null ? "" : "Got different objects:\nexpected: " + expected.getClass().getName() + "\nactual: " + actual.getClass().getName() + "\n";
                throw new ComparisonFailure(cleanMessage, expectedString, actualString);
            }
        }
        System.setOut(actualOut);
        System.out.println(green + "Test passed!" + reset);
        System.setOut(newOut);
    }

    public static void assertEquals(Object expected, Object actual) throws ComparisonFailure {
        assertEquals(null, expected, actual);
    }

    public static void assertEqual(String message, Object expected, Object actual) {
        try {
            assertEquals(message, expected, actual);
        } catch (ComparisonFailure e) {
            e.message();
        }
    }

    public static void setActualOut(PrintStream out) {
        actualOut = out;
    }
}
