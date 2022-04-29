package net.bruhitsalex.mmg.cmds.cmds;

import net.bruhitsalex.mmg.cmds.Command;
import net.bruhitsalex.mmg.manager.MMGManager;
import net.bruhitsalex.mmg.manager.Point;
import net.bruhitsalex.mmg.utils.ChatUtils;
import net.bruhitsalex.mmg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

import java.util.List;

public class AddPointCommand extends Command {

    public AddPointCommand() {
        super("addpoint", true);
    }

    @Override
    public void onExecute(List<String> args) {
        BlockPos pos = Utils.round(Minecraft.getMinecraft().thePlayer);
        Point point = new Point(pos);
        MMGManager.getList().add(point);
        ChatUtils.sendMessage("Added point '" + point.getName() + "' to the list.");
    }

}
