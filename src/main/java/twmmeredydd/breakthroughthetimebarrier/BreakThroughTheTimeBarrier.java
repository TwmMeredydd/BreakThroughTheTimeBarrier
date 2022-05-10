package twmmeredydd.breakthroughthetimebarrier;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import twmmeredydd.breakthroughthetimebarrier.client.ModClientSetup;
import twmmeredydd.breakthroughthetimebarrier.entity.ModEntityTypes;
import twmmeredydd.breakthroughthetimebarrier.item.ModItems;

@Mod(BreakThroughTheTimeBarrier.MOD_ID)
public class BreakThroughTheTimeBarrier {
    public static final String MOD_ID = "breakthroughthetimebarrier";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation getRL(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PLUSTONIUM_ALLOY_VIAL.get());
        }
    };

    public BreakThroughTheTimeBarrier() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModEntityTypes.ENTITY_TYPE_REGISTER.register(bus);

        bus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ModClientSetup::init));
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
