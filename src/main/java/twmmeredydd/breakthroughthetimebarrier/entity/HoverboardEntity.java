package twmmeredydd.breakthroughthetimebarrier.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public abstract class HoverboardEntity extends Entity {
    private int charge;
    private Status status;
    private int speed;
    private static int maxSpeed;

    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(HoverboardEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> DATA_ID_HAS_CHARGE = SynchedEntityData.defineId(HoverboardEntity.class, EntityDataSerializers.BOOLEAN);

    protected HoverboardEntity(EntityType p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }


    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_ID_DAMAGE, 0.0f);
        this.entityData.define(DATA_ID_HAS_CHARGE, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putInt("Charge", charge);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Charge", Tag.TAG_INT)){
            charge = pCompound.getInt("Charge");
        }
    }

    @Nullable
    @Override
    public Entity getControllingPassenger() {
        return this.getFirstPassenger();
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public abstract boolean canHoverOnLiquid();

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return Boat.canVehicleCollide(this, pEntity);
    }

    @Override
    protected boolean canAddPassenger(Entity pPassenger) {
        return this.getPassengers().isEmpty() && !(this.level.getBlockState(this.blockPosition()).getBlock() instanceof LiquidBlock);
    }

    @Override
    public void tick() {
        super.tick();
    }

    public enum Status {
        INACTIVE,
        IDLE,
        HOVERING,
    }

    public abstract int getMaxCharge();

    /*public enum Type {
        MATTEL("mattel"),
        NO_TECH("no_tech"),
        PIT_BULL("pit_bull"),
        QUESTION_MARK("question_mark"),
        RISING_SUN("rising_sun");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }*/
}
