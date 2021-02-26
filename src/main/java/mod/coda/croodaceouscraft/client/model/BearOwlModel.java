package mod.coda.croodaceouscraft.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BearOwlModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape8;
    public ModelRenderer shape8_1;
    public ModelRenderer shape14;
    public ModelRenderer shape3;
    public ModelRenderer shape3_1;
    public ModelRenderer shape7;
    public ModelRenderer shape4;
    public ModelRenderer shape4_1;
    public ModelRenderer shape9;
    public ModelRenderer shape9_1;
    public ModelRenderer shape9_2;
    public ModelRenderer shape9_3;
    public ModelRenderer shape15;
    public ModelRenderer shape15_1;
    public ModelRenderer shape23;
    public ModelRenderer shape16;
    public ModelRenderer shape17;
    public ModelRenderer shape17_1;
    public ModelRenderer shape16_1;
    public ModelRenderer shape17_2;
    public ModelRenderer shape17_3;
    public ModelRenderer shape24;
    public ModelRenderer shape25;

    public BearOwlModel() {
        this.textureWidth = 192;
        this.textureHeight = 128;
        this.shape3_1 = new ModelRenderer(this, 2, 89);
        this.shape3_1.setRotationPoint(-11.0F, -0.5F, -8.0F);
        this.shape3_1.addBox(-7.0F, -5.0F, 0.0F, 7.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape3_1, 0.0F, 0.6255260065779288F, 0.0F);
        this.shape15 = new ModelRenderer(this, 94, 55);
        this.shape15.setRotationPoint(5.0F, -3.0F, 20.0F);
        this.shape15.addBox(0.0F, -3.0F, -5.0F, 8.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.shape16_1 = new ModelRenderer(this, 121, 37);
        this.shape16_1.setRotationPoint(-3.5F, 13.0F, -2.5F);
        this.shape16_1.addBox(-3.0F, -3.0F, -1.0F, 6.0F, 19.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.shape4 = new ModelRenderer(this, 156, 96);
        this.shape4.mirror = true;
        this.shape4.setRotationPoint(-7.0F, -6.5F, 0.0F);
        this.shape4.addBox(0.0F, -10.5F, 0.0F, 14.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.shape15_1 = new ModelRenderer(this, 94, 55);
        this.shape15_1.setRotationPoint(-5.0F, -3.0F, 20.0F);
        this.shape15_1.addBox(-8.0F, -3.0F, -5.0F, 8.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.shape14 = new ModelRenderer(this, 87, 82);
        this.shape14.setRotationPoint(0.0F, 0.5F, 9.0F);
        this.shape14.addBox(-10.0F, -9.0F, -2.0F, 20.0F, 18.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.shape8 = new ModelRenderer(this, 69, 74);
        this.shape8.setRotationPoint(-8.5F, 5.5F, 0.0F);
        this.shape8.addBox(-5.0F, -3.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.shape4_1 = new ModelRenderer(this, 156, 96);
        this.shape4_1.setRotationPoint(7.0F, -6.5F, 0.0F);
        this.shape4_1.addBox(-14.0F, -10.5F, 0.0F, 14.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 88);
        this.shape1.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.shape1.addBox(-12.0F, -10.5F, -9.5F, 24.0F, 21.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.shape9_1 = new ModelRenderer(this, 0, 100);
        this.shape9_1.setRotationPoint(1.0F, 19.5F, -4.0F);
        this.shape9_1.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.shape25 = new ModelRenderer(this, 131, 70);
        this.shape25.setRotationPoint(0.0F, 0.0F, 24.0F);
        this.shape25.addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape25, 0.3490658503988659F, 0.0F, 0.0F);
        this.shape23 = new ModelRenderer(this, 1, 24);
        this.shape23.setRotationPoint(0.0F, -4.5F, 25.0F);
        this.shape23.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape23, -1.0471975511965976F, 0.0F, 0.0F);
        this.shape17_1 = new ModelRenderer(this, 0, 46);
        this.shape17_1.setRotationPoint(-1.5F, 14.5F, 0.0F);
        this.shape17_1.addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.shape3 = new ModelRenderer(this, 2, 89);
        this.shape3.mirror = true;
        this.shape3.setRotationPoint(11.0F, -0.5F, -8.0F);
        this.shape3.addBox(0.0F, -5.0F, 0.0F, 7.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape3, 0.0F, -0.7819074915776542F, 0.0F);
        this.shape17_3 = new ModelRenderer(this, 0, 46);
        this.shape17_3.setRotationPoint(-1.5F, 14.5F, 0.0F);
        this.shape17_3.addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.shape24 = new ModelRenderer(this, 44, 21);
        this.shape24.setRotationPoint(0.0F, 0.0F, 27.0F);
        this.shape24.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape24, 0.8726646259971648F, 0.0F, 0.0F);
        this.shape7 = new ModelRenderer(this, 57, 62);
        this.shape7.setRotationPoint(0.0F, 3.0F, -12.0F);
        this.shape7.addBox(-4.0F, -3.5F, -3.0F, 8.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.shape17_2 = new ModelRenderer(this, 0, 46);
        this.shape17_2.setRotationPoint(1.5F, 14.5F, 0.0F);
        this.shape17_2.addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.shape8_1 = new ModelRenderer(this, 69, 74);
        this.shape8_1.setRotationPoint(8.5F, 5.5F, 0.0F);
        this.shape8_1.addBox(-3.0F, -3.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.shape16 = new ModelRenderer(this, 121, 37);
        this.shape16.setRotationPoint(3.5F, 13.0F, -2.5F);
        this.shape16.addBox(-3.0F, -3.0F, -1.0F, 6.0F, 19.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 61);
        this.shape2.setRotationPoint(0.0F, 2.0F, -9.5F);
        this.shape2.addBox(-11.0F, -6.5F, -12.0F, 22.0F, 13.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.shape17 = new ModelRenderer(this, 0, 46);
        this.shape17.setRotationPoint(1.5F, 14.5F, 0.0F);
        this.shape17.addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.shape9_3 = new ModelRenderer(this, 0, 100);
        this.shape9_3.setRotationPoint(-1.0F, 19.5F, -4.0F);
        this.shape9_3.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 100);
        this.shape9.setRotationPoint(-3.0F, 19.5F, -4.0F);
        this.shape9.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.shape9_2 = new ModelRenderer(this, 0, 100);
        this.shape9_2.setRotationPoint(3.0F, 19.5F, -4.0F);
        this.shape9_2.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.shape2.addChild(this.shape3_1);
        this.shape14.addChild(this.shape15);
        this.shape15_1.addChild(this.shape16_1);
        this.shape3.addChild(this.shape4);
        this.shape14.addChild(this.shape15_1);
        this.shape1.addChild(this.shape14);
        this.shape1.addChild(this.shape8);
        this.shape3_1.addChild(this.shape4_1);
        this.shape8.addChild(this.shape9_1);
        this.shape24.addChild(this.shape25);
        this.shape14.addChild(this.shape23);
        this.shape16.addChild(this.shape17_1);
        this.shape2.addChild(this.shape3);
        this.shape16_1.addChild(this.shape17_3);
        this.shape23.addChild(this.shape24);
        this.shape2.addChild(this.shape7);
        this.shape16_1.addChild(this.shape17_2);
        this.shape1.addChild(this.shape8_1);
        this.shape15.addChild(this.shape16);
        this.shape1.addChild(this.shape2);
        this.shape16.addChild(this.shape17);
        this.shape8_1.addChild(this.shape9_3);
        this.shape8.addChild(this.shape9);
        this.shape8_1.addChild(this.shape9_2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.shape1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
