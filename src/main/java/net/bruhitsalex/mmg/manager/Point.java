package net.bruhitsalex.mmg.manager;

import lombok.*;
import net.minecraft.util.BlockPos;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Point {

    private String name;
    private BlockPos position;
    private List<Point> connectedTo;

    public Point(BlockPos position) {
        this.name = MMGManager.getNextName();
        this.position = position;
        this.connectedTo = new ArrayList<>();
    }

}
