package net.bruhitsalex.mmg.manager;

import lombok.Getter;
import net.minecraft.util.BlockPos;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Point {

    private final String name;
    private final BlockPos position;
    private final List<Point> connectedTo;

    public Point(BlockPos position) {
        this.name = MMGManager.getNextName();
        this.position = position;
        this.connectedTo = new ArrayList<>();
    }

}
