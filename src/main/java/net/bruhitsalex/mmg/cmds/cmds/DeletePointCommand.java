package net.bruhitsalex.mmg.cmds.cmds;

import net.bruhitsalex.mmg.cmds.Command;
import net.bruhitsalex.mmg.manager.MMGManager;
import net.bruhitsalex.mmg.manager.Point;
import net.bruhitsalex.mmg.utils.ChatUtils;

import java.util.List;
import java.util.Optional;

public class DeletePointCommand extends Command {

    public DeletePointCommand() {
        super("deletepoint", true);
    }

    @Override
    public void onExecute(List<String> args) {
        if (args.size() == 0) {
            ChatUtils.sendMessage("You need to provide a point name to delete. E.g: /mmg AJ");
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

        Point point = pointOptional.get();

        MMGManager.getList()
                .forEach(point2 -> {
                    point2.getConnectedTo().remove(point);
                });

        MMGManager.getList().remove(point);

        ChatUtils.sendMessage("Removed point '" + pointName + "' from the matrix.");
    }

}
