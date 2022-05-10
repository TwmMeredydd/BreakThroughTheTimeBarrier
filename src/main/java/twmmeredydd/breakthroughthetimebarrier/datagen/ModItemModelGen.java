package twmmeredydd.breakthroughthetimebarrier.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import twmmeredydd.breakthroughthetimebarrier.BreakThroughTheTimeBarrier;

public class ModItemModelGen extends ItemModelProvider {
    public ModItemModelGen(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BreakThroughTheTimeBarrier.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    private void basicModel(Item item) {
        singleTexture(item.getRegistryName().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/" + item.getRegistryName().getPath()));
    }

    private void blockItemBasic(Block block) {
        withExistingParent(block.getRegistryName().getPath(), block.getRegistryName());
    }
}
