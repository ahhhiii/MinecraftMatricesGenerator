package net.bruhitsalex.mmg.manager;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.bruhitsalex.mmg.utils.ChatUtils;
import net.minecraft.util.BlockPos;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class JSONManager {

    public static boolean writeToJson(List<Point> list) {
        JsonObject json = new JsonObject();
        list.forEach(point -> {
            json.add(point.getName(), getPointToJson(point));
        });

        File tempFile;
        try {
            tempFile = File.createTempFile("matrices", ".json");
        } catch (Exception e) {
            e.printStackTrace();
            ChatUtils.sendMessage("Unable to create file to store data.. Check your minecraft output log.");
            return false;
        }

        try {
            Files.write(tempFile.toPath(), new GsonBuilder().setPrettyPrinting().create().toJson(json).getBytes());
            ChatUtils.sendMessage("Written to file: " + tempFile.getAbsolutePath());
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(tempFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ChatUtils.sendMessage("Unable to write json to file.. Writing in your output log (find in .minecraft/logs/)");
            System.out.println(json);
            return false;
        }

        return true;
    }

    public static JsonObject getPointToJson(Point point) {
        JsonObject json = new JsonObject();
        json.addProperty("name", point.getName());
        json.add("position", getPosToJson(point.getPosition()));

        JsonArray array = new JsonArray();
        for (Point point1 : point.getConnectedTo()) {
            array.add(new JsonPrimitive(point1.getName()));
        }

        json.add("connectedTo", array);
        return json;
    }

    public static JsonObject getPosToJson(BlockPos pos) {
        JsonObject json = new JsonObject();
        json.addProperty("x", pos.getX());
        json.addProperty("y", pos.getY());
        json.addProperty("z", pos.getZ());
        return json;
    }

}
