package twmmeredydd.breakthroughthetimebarrier.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import twmmeredydd.breakthroughthetimebarrier.BreakThroughTheTimeBarrier;

@Mod.EventBusSubscriber(modid = BreakThroughTheTimeBarrier.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeClient()) {
            generator.addProvider(new ModItemModelGen(generator, event.getExistingFileHelper()));
        } else if (event.includeServer()) {
            generator.addProvider(new ModBlockStateGen(generator, event.getExistingFileHelper()));
        }
    }
}
