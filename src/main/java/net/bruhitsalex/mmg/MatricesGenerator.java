package net.bruhitsalex.mmg;

import net.bruhitsalex.mmg.manager.MMGManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(name = "MatricesGenerator", modid = "mmg", version = "1.0", acceptedMinecraftVersions = "1.8.9")
public class MatricesGenerator {

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        MMGManager.init();


    }

}
