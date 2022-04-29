package net.bruhitsalex.mmg.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;

public class Utils {

    public static String toAlphabetic(int i) {
        if (i < 0) {
            return "-" + toAlphabetic(-i - 1);
        }

        int quot = i / 26;
        int rem = i % 26;
        char letter = (char) ((int) 'A' + rem);
        if (quot == 0) {
            return "" + letter;
        } else {
            return toAlphabetic(quot-1) + letter;
        }
    }

    public static BlockPos round(Entity entity) {
        return new BlockPos((int) entity.posX, (int) entity.posY, (int) entity.posZ);
    }

}
