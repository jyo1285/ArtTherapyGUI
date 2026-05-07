package util;

public class Validator {

    // EMPTY FIELD

    public static boolean isEmpty(
            String text
    ) {

        return text == null
                || text.trim().isEmpty();
    }

    // PHONE VALIDATION

    public static boolean isValidPhone(
            String phone
    ) {

        return phone.matches(
                "[0-9]{10}"
        );
    }

    // NUMBER VALIDATION

    public static boolean isNumber(
            String value
    ) {

        return value.matches(
                "[0-9]+"
        );
    }
}