package mod.coda.croodaceouscraft.util;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.client.renderer.JackrobatRenderer;
import mod.coda.croodaceouscraft.init.CroodsBlocks;
import mod.coda.croodaceouscraft.init.CroodsEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Croods.MOD_ID)
public class ClientEventBusSubscriber {

    public static void clientSetup() {
        RenderTypeLookup.setRenderLayer(CroodsBlocks.CROODACEOUS_SHRUB.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(CroodsEntities.JACKROBAT.get(), JackrobatRenderer::new);
    }
}
