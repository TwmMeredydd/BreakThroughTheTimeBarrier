package twmmeredydd.breakthroughthetimebarrier.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import twmmeredydd.breakthroughthetimebarrier.BreakThroughTheTimeBarrier;

public class ModBlockStateGen extends BlockStateProvider {
    public ModBlockStateGen(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, BreakThroughTheTimeBarrier.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
