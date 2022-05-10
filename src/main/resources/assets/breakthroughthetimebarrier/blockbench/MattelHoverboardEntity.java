// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class custom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart base;
	private final ModelPart back;
	private final ModelPart front_disc;
	private final ModelPart back_disc;

	public custom_model(ModelPart root) {
		this.base = root.getChild("base");
		this.back = root.getChild("back");
		this.front_disc = root.getChild("front_disc");
		this.back_disc = root.getChild("back_disc");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -5.0F, 5.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(2.0F, 18.964F, -7.1945F));

		PartDefinition back_r1 = back.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-4.5F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition front_disc = partdefinition.addOrReplaceChild("front_disc", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -4.0F, 3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition back_disc = partdefinition.addOrReplaceChild("back_disc", CubeListBuilder.create().texOffs(12, 16).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, buffer, packedLight, packedOverlay);
		back.render(poseStack, buffer, packedLight, packedOverlay);
		front_disc.render(poseStack, buffer, packedLight, packedOverlay);
		back_disc.render(poseStack, buffer, packedLight, packedOverlay);
	}
}