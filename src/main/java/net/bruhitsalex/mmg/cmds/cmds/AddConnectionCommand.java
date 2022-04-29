package net.bruhitsalex.mmg.cmds.cmds;

import net.bruhitsalex.mmg.cmds.Command;
import net.bruhitsalex.mmg.manager.MMGManager;
import net.bruhitsalex.mmg.manager.Point;
import net.bruhitsalex.mmg.utils.ChatUtils;
import net.bruhitsalex.mmg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

import java.util.List;
import java.util.Optional;

public class AddConnectionCommand extends Command {

    public AddConnectionCommand() {
        super("addconnection", true);
    }

    @Override
    public void onExecute(List<String> args) {
        if (args.size() == 0) {
            ChatUtils.sendMessage("You need to provide a point name to add a connection to. E.g: /mmg AJ");
            return;
        }

        String pointName = args.get(0);

        Optional<Point> pointOptional = MMGManager.getList().stream()
                .filter(point1 -> point1.getName().equalsIgnoreCase(pointName))
                .findFirst();

        if (!pointOptional.isPresent()) {
            ChatUtils.sendMessage("Point '" + pointName + "' doesn't exist.");
            return;
        }

        BlockPos currentPos = Utils.round(Minecraft.getMinecraft().thePlayer);
        Optional<Point> secondPointOptional = MMGManager.getList().stream()
                .filter(point1 -> point1.getPosition().equals(currentPos))
                .findFirst();

        if (!secondPointOptional.isPresent()) {
            ChatUtils.sendMessage("Cannot find point for your position.");
            return;
        }

        Point targetPoint = pointOptional.get();
        Point foundPoint = secondPointOptional.get();

        targetPoint.getConnectedTo().add(foundPoint);
        foundPoint.getConnectedTo().add(targetPoint);

        ChatUtils.sendMessage("Added point " + foundPoint.getName() + " to point " + targetPoint.getName() + "!");
    }

}
