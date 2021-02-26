package mod.coda.croodaceouscraft.client.renderer;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.client.model.BearOwlModel;
import mod.coda.croodaceouscraft.entity.BearOwlEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BearOwlRenderer extends MobRenderer<BearOwlEntity, BearOwlModel<BearOwlEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Croods.MOD_ID, "textures/entity/bear_owl.png");

    public BearOwlRenderer(EntityRendererManager manager) {
        super(manager, new BearOwlModel<>(), 1.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(BearOwlEntity entity) {
        return TEXTURE;
    }
}
