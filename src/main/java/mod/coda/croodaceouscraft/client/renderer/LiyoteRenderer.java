package mod.coda.croodaceouscraft.client.renderer;

import com.google.common.collect.Maps;
import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.client.model.LiyoteModel;
import mod.coda.croodaceouscraft.entity.LiyoteEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;

import java.util.Map;

public class LiyoteRenderer extends MobRenderer<LiyoteEntity, LiyoteModel<LiyoteEntity>> {
    protected static final ResourceLocation ORANGE = new ResourceLocation(Croods.MOD_ID, "textures/entity/liyote/liyote_orange.png");
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(Croods.MOD_ID, "textures/entity/liyote/liyote_orange.png"));
        hashMap.put(1, new ResourceLocation(Croods.MOD_ID, "textures/entity/liyote/liyote_white.png"));
    });
    public LiyoteRenderer(EntityRendererManager manager) {
        super(manager, new LiyoteModel<>(), 0.45f);
    }

    @Override
    public ResourceLocation getEntityTexture(LiyoteEntity entity) {
        return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
    }
}
