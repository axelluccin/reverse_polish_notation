package fr.lacombe.rpn;

public class Numeric {
    public static boolean isNumeric(String str) {
        if (str == null)
            return false;
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
