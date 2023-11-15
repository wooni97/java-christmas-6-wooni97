package christmas.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    private StringUtils() {}

    public static List<String> splitString(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
