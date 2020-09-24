package mod.coda.croodaceouscraft.util;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.init.CroodsBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Croods.MOD_ID)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(CroodsBlocks.CROODACEOUS_SHRUB.get(), RenderType.getCutout());
    }
}
