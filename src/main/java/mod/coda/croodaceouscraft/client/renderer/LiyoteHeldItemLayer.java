package mod.coda.croodaceouscraft.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import mod.coda.croodaceouscraft.client.model.LiyoteModel;
import mod.coda.croodaceouscraft.entity.LiyoteEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class LiyoteHeldItemLayer extends LayerRenderer<LiyoteEntity, LiyoteModel<LiyoteEntity>> {
    public LiyoteHeldItemLayer(IEntityRenderer<LiyoteEntity, LiyoteModel<LiyoteEntity>> p_i50938_1_) {
        super(p_i50938_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, LiyoteEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.push();

        matrixStackIn.translate((double)((this.getEntityModel()).head.rotationPointX / 16.0F), (double)((this.getEntityModel()).head.rotationPointY / 16.0F), (double)((this.getEntityModel()).head.rotationPointZ / 16.0F));
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(netHeadYaw));
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90));

        matrixStackIn.translate(-0.5D, -0.1D, -0.1D);
        matrixStackIn.scale(0.9F, 0.9F, 0.9F);

        ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
        Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.GROUND, false, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pop();
    }
}