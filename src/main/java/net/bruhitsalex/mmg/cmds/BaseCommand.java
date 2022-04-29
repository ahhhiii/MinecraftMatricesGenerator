package net.bruhitsalex.mmg.cmds;

import net.bruhitsalex.mmg.cmds.cmds.*;
import net.bruhitsalex.mmg.manager.MMGManager;
import net.bruhitsalex.mmg.utils.ChatUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseCommand extends CommandBase {

    private static final List<Command> COMMANDS = Arrays.asList(
            new StartCommand(),
            new FinishCommand(),
            new AddPointCommand(),
            new DeletePointCommand(),
            new AddConnectionCommand()
    );

    @Override
    public String getCommandName() {
        return "mmg";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/mmg <args>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            ChatUtils.sendMessage("You must provide a sub-command: "
                    + COMMANDS.stream().map(Command::getSubCmd).collect(Collectors.toList()));
            return;
        }

        boolean found = false;
        Command foundCommand = null;
        for (Command command : COMMANDS) {
            if (command.getSubCmd().equalsIgnoreCase(args[0])) {
                found = true;
                foundCommand = command;
            }
        }

        if (!found) {
            ChatUtils.sendMessage("That sub-command cannot be found, use one of the following: "
                    + COMMANDS.stream().map(Command::getSubCmd).collect(Collectors.toList()));
            return;
        }

        if (foundCommand.isRequiresStarted() && !MMGManager.isActive()) {
            ChatUtils.sendMessage("This command requires you have started mmg. You can do so with: /mmg " + StartCommand.NAME + ".");
            return;
        }

        List<String> newArgs = new ArrayList<>(Arrays.asList(args).subList(1, args.length));
        foundCommand.onExecute(newArgs);
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
