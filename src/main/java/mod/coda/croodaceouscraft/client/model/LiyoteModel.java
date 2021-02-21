package mod.coda.croodaceouscraft.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.coda.croodaceouscraft.entity.LiyoteEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LiyoteModel<T extends Entity> extends EntityModel<LiyoteEntity> {
    public ModelRenderer chest;
    public ModelRenderer body;
    public ModelRenderer leftArm;
    public ModelRenderer rightArm;
    public ModelRenderer head;
    public ModelRenderer leftLeg;
    public ModelRenderer rightLeg;
    public ModelRenderer tail;
    public ModelRenderer snout;
    public ModelRenderer earLeft;
    public ModelRenderer earRight;
    public ModelRenderer tongue;

    public LiyoteModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.tongue = new ModelRenderer(this, 32, 11);
        this.tongue.setRotationPoint(1.5F, 0.5F, -1.0F);
        this.tongue.addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tongue, 0.0F, 0.0F, -0.03490658503988659F);
        this.head = new ModelRenderer(this, 0, 3);
        this.head.setRotationPoint(0.0F, 14.5F, -5.5F);
        this.head.addBox(-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.leftLeg = new ModelRenderer(this, 23, 22);
        this.leftLeg.setRotationPoint(1.0F, 0.0F, 6.0F);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftLeg, 0.3490658503988659F, 0.0F, -0.3490658503988659F);
        this.earLeft = new ModelRenderer(this, 33, 3);
        this.earLeft.setRotationPoint(1.0F, -2.5F, -2.5F);
        this.earLeft.addBox(-0.5F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 37, 2);
        this.body.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.body.addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(body, -0.2617993877991494F, 0.0F, 0.0F);
        this.rightLeg = new ModelRenderer(this, 23, 22);
        this.rightLeg.mirror = true;
        this.rightLeg.setRotationPoint(-1.0F, 0.0F, 6.0F);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightLeg, 0.3490658503988659F, 0.0F, 0.3490658503988659F);
        this.snout = new ModelRenderer(this, 0, 14);
        this.snout.setRotationPoint(0.0F, 1.0F, -5.0F);
        this.snout.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.rightArm = new ModelRenderer(this, 32, 18);
        this.rightArm.mirror = true;
        this.rightArm.setRotationPoint(-2.0F, 1.5F, 0.0F);
        this.rightArm.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightArm, -0.17453292519943295F, 0.0F, 0.2617993877991494F);
        this.chest = new ModelRenderer(this, 0, 21);
        this.chest.setRotationPoint(0.0F, 15.5F, -4.0F);
        this.chest.addBox(-3.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 33, 16);
        this.tail.setRotationPoint(0.0F, 0.0F, 7.5F);
        this.tail.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail, -0.17453292519943295F, 0.0F, 0.0F);
        this.leftArm = new ModelRenderer(this, 32, 18);
        this.leftArm.setRotationPoint(2.0F, 1.5F, 0.0F);
        this.leftArm.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftArm, -0.17453292519943295F, 0.0F, -0.2617993877991494F);
        this.earRight = new ModelRenderer(this, 33, 3);
        this.earRight.mirror = true;
        this.earRight.setRotationPoint(-1.0F, -2.5F, -2.5F);
        this.earRight.addBox(-5.5F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.snout.addChild(this.tongue);
        this.body.addChild(this.leftLeg);
        this.head.addChild(this.earLeft);
        this.chest.addChild(this.body);
        this.body.addChild(this.rightLeg);
        this.head.addChild(this.snout);
        this.chest.addChild(this.rightArm);
        this.body.addChild(this.tail);
        this.chest.addChild(this.leftArm);
        this.head.addChild(this.earRight);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.chest, this.head).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(LiyoteEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 1.0f;
        float degree = 1.5f;
        limbSwingAmount = MathHelper.clamp(limbSwingAmount, -0.5f, 0.5f);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.1F * limbSwingAmount + 0.4F;
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.1F * limbSwingAmount + 0.4F;
        this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.1F * limbSwingAmount - 0.1F;
        this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.1F * limbSwingAmount - 0.1F;
        this.body.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
        this.chest.rotateAngleY = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * -0.2F * limbSwingAmount;
        this.tail.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.3F * limbSwingAmount + 0.1F;
        this.tail.rotateAngleY = MathHelper.cos(-1.0F + limbSwing * speed * 0.2F) * degree * 0.14F * limbSwingAmount;
        this.tongue.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount - 0.15F;
        this.earLeft.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.15F * limbSwingAmount;
        this.earRight.rotateAngleZ = MathHelper.cos(0.5F + limbSwing * speed * 0.4F) * degree * -0.15F * limbSwingAmount;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
