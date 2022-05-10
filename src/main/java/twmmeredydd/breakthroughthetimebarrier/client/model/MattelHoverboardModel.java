package twmmeredydd.breakthroughthetimebarrier.client.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import twmmeredydd.breakthroughthetimebarrier.BreakThroughTheTimeBarrier;
import twmmeredydd.breakthroughthetimebarrier.entity.MattelHoverboardEntity;

public class MattelHoverboardModel extends HierarchicalModel<MattelHoverboardEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(BreakThroughTheTimeBarrier.getRL("mattel_hoverboard"), "main");

    private final ModelPart root;
    private final ModelPart base;
    private final ModelPart back;
    private final ModelPart front_disc;
    private final ModelPart back_disc;

    public MattelHoverboardModel(ModelPart root) {
        this.root = root;
        this.base = root.getChild("base");
        this.back = root.getChild("back");
        this.front_disc = root.getChild("front_disc");
        this.back_disc = root.getChild("back_disc");
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -5.0F, 5.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));
        PartDefinition back = partDefinition.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(2.0F, 18.964F, -7.1945F));
        back.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-4.5F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("front_disc", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -4.0F, 3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));
        partDefinition.addOrReplaceChild("back_disc", CubeListBuilder.create().texOffs(12, 16).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(MattelHoverboardEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }
}
