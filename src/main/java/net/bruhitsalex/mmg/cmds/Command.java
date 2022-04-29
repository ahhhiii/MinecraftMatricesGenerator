package net.bruhitsalex.mmg.cmds;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Command {

    private String subCmd;
    private boolean requiresStarted;

    public abstract void onExecute(List<String> args);

}
