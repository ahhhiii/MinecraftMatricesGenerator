package net.bruhitsalex.mmg.cmds.cmds;

import net.bruhitsalex.mmg.cmds.Command;
import net.bruhitsalex.mmg.manager.MMGManager;
import net.bruhitsalex.mmg.utils.ChatUtils;

import java.util.List;

public class StartCommand extends Command {

    public static final String NAME = "start";

    public StartCommand() {
        super(NAME, false);
    }

    @Override
    public void onExecute(List<String> args) {
        MMGManager.init();
        ChatUtils.sendMessage("Started MMG... First add all of your points. Make sure not to add one by mistake.");
    }

}
