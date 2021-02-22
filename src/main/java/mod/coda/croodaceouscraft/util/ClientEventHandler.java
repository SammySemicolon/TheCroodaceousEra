package mod.coda.croodaceouscraft.util;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.client.renderer.JackrobatRenderer;
import mod.coda.croodaceouscraft.client.renderer.LiyoteRenderer;
import mod.coda.croodaceouscraft.init.CroodsBlocks;
import mod.coda.croodaceouscraft.init.CroodsEntities;
import mod.coda.croodaceouscraft.item.CroodsSpawnEggItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Croods.MOD_ID)
public class ClientEventHandler {

    public static void clientSetup() {
        RenderTypeLookup.setRenderLayer(CroodsBlocks.CROODACEOUS_SHRUB.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(CroodsEntities.JACKROBAT.get(), JackrobatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(CroodsEntities.LIYOTE.get(), LiyoteRenderer::new);
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_WALL_BRANCHES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_BRANCHES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_DOOR.get(), RenderType.getCutout());
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((CroodsSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (CroodsSpawnEggItem e : CroodsSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }
}
