package twmmeredydd.breakthroughthetimebarrier.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class MattelHoverboardEntity extends HoverboardEntity {
    public MattelHoverboardEntity(EntityType pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public boolean canHoverOnLiquid() {
        return false;
    }

    @Override
    public int getMaxCharge() {
        return 100;
    }
}
