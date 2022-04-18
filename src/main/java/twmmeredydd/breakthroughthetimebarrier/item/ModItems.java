package twmmeredydd.breakthroughthetimebarrier.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twmmeredydd.breakthroughthetimebarrier.BreakThroughTheTimeBarrier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BreakThroughTheTimeBarrier.MOD_ID);

    public static final RegistryObject<Item> PLUSTONIUM_ALLOY_VIAL = ITEMS.register("plustonium_alloy_vial", () -> new Item(new Item.Properties().tab(BreakThroughTheTimeBarrier.ITEM_GROUP).stacksTo(16)));

}
