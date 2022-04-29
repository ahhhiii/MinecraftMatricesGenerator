package net.bruhitsalex.mmg;

import net.bruhitsalex.mmg.cmds.BaseCommand;
import net.bruhitsalex.mmg.rendering.RenderHandler;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(name = "MatricesGenerator", modid = "mmg", version = "1.0", acceptedMinecraftVersions = "1.8.9")
public class MatricesGenerator {

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new BaseCommand());
        MinecraftForge.EVENT_BUS.register(new RenderHandler());
    }

}
