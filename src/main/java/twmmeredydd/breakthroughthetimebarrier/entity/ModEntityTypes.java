package twmmeredydd.breakthroughthetimebarrier.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twmmeredydd.breakthroughthetimebarrier.BreakThroughTheTimeBarrier;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, BreakThroughTheTimeBarrier.MOD_ID);

    public static final RegistryObject<EntityType<MattelHoverboardEntity>> MATTEL_HOVERBOARD = ENTITY_TYPE_REGISTER.register("mattel_hoverboard", () -> EntityType.Builder.of(MattelHoverboardEntity::new, MobCategory.MISC).build("mattel_hoverboard"));
}
