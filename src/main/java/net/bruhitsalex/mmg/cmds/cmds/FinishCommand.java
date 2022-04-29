package net.bruhitsalex.mmg.cmds.cmds;

import net.bruhitsalex.mmg.cmds.Command;
import net.bruhitsalex.mmg.manager.MMGManager;

import java.util.List;

public class FinishCommand extends Command {

    public FinishCommand() {
        super("finish", true);
    }

    @Override
    public void onExecute(List<String> args) {
        MMGManager.finish();
    }

}
