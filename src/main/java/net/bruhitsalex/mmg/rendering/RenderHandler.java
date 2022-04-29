package net.bruhitsalex.mmg.rendering;

import net.bruhitsalex.mmg.manager.MMGManager;
import net.bruhitsalex.mmg.manager.Point;
import net.bruhitsalex.mmg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;

public class RenderHandler {

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {
        if (!MMGManager.isActive()) {
            return;
        }

        Vec3 currentPos = Utils.renderable(Utils.round(Minecraft.getMinecraft().thePlayer));

        for (Point point : MMGManager.getList()) {
            Vec3 position = Utils.renderable(point.getPosition());

            if (currentPos.distanceTo(position) > 50) {
                return;
            }

            for (Point connectedTo : point.getConnectedTo()) {
                RenderUtils.drawLines(
                        Arrays.asList(position, Utils.renderable(connectedTo.getPosition())),
                        2f, event.partialTicks);
            }

            RenderUtils.renderLabel(position.addVector(0, 0.5, 0), point.getName(), event.partialTicks);
            RenderUtils.drawFilledEsp(point.getPosition());
        }
    }

}
