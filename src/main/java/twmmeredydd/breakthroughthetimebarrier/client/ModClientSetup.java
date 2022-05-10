package twmmeredydd.breakthroughthetimebarrier.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import twmmeredydd.breakthroughthetimebarrier.client.model.MattelHoverboardModel;
import twmmeredydd.breakthroughthetimebarrier.client.render.MattelHoverboardRenderer;
import twmmeredydd.breakthroughthetimebarrier.entity.ModEntityTypes;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientSetup {
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.MATTEL_HOVERBOARD.get(), MattelHoverboardRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MattelHoverboardModel.LAYER_LOCATION, MattelHoverboardModel::createBodyLayer);
    }
}
