package net.bruhitsalex.mmg.cmds;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.client.ClientCommandHandler;

public abstract class BaseCommand extends CommandBase {

    private final String name;
    public BaseCommand(String name) {
        this.name = name;
        ClientCommandHandler.instance.registerCommand(this);
    }

    public abstract void onExecute(String[] args);

    @Override
    public String getCommandName() {
        return name;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return name;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        onExecute(args);
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
