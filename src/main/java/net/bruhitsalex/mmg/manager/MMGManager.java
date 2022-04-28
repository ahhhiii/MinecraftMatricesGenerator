package net.bruhitsalex.mmg.manager;

import net.bruhitsalex.mmg.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MMGManager {

    private static int pos;
    private static List<Point> list;

    public static void init() {
        pos = -1;
        list = new ArrayList<>();
    }

    public static void finish() {
        if (JSONManager.writeToJson(list)) {
            list = null;
            pos = -1;
        }
    }

    public boolean isActive() {
        return list != null;
    }

    public static String getNextName() {
        pos++;
        return Utils.toAlphabetic(pos);
    }

}
