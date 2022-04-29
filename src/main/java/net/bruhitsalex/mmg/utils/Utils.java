package net.bruhitsalex.mmg.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

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

    public static BlockPos getBlockPos() {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        int blockX = MathHelper.floor_double(player.posX);
        int blockY = MathHelper.floor_double(player.posY-0.2D - player.getYOffset());
        int blockZ = MathHelper.floor_double(player.posZ);
        return new BlockPos(blockX, blockY, blockZ);
    }

    public static Vec3 renderable(BlockPos position) {
        return new Vec3(position.getX() + 0.5, position.getY(), position.getZ() + 0.5);
    }

}
