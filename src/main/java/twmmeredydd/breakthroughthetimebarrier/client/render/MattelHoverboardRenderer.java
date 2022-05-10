package twmmeredydd.breakthroughthetimebarrier.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import twmmeredydd.breakthroughthetimebarrier.BreakThroughTheTimeBarrier;
import twmmeredydd.breakthroughthetimebarrier.client.model.MattelHoverboardModel;
import twmmeredydd.breakthroughthetimebarrier.entity.MattelHoverboardEntity;

public class MattelHoverboardRenderer extends EntityRenderer<MattelHoverboardEntity> {
    private static final ResourceLocation TEXTURE_LOCATION = BreakThroughTheTimeBarrier.getRL("textures/entity/mattel_hoverboard.png");
    private final MattelHoverboardModel model;

    public MattelHoverboardRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
        this.model = new MattelHoverboardModel(p_174008_.bakeLayer(MattelHoverboardModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(MattelHoverboardEntity pEntity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public void render(MattelHoverboardEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        pMatrixStack.pushPose();
        pMatrixStack.scale(-1f, -1f, -1f);
        VertexConsumer vertexConsumer = pBuffer.getBuffer(model.renderType(TEXTURE_LOCATION));
        model.renderToBuffer(pMatrixStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        pMatrixStack.popPose();
    }

    @Override
    protected boolean shouldShowName(MattelHoverboardEntity pEntity) {
        return false;
    }
}
