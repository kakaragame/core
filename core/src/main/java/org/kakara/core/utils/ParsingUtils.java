package org.kakara.core.utils;

import java.awt.*;

public class ParsingUtils {
    public static Point parsePoint(String position) {
        String[] split = position.split(",");
        return new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}
