package mod.coda.croodaceouscraft;

import mod.coda.croodaceouscraft.entity.JackrobatEntity;
import mod.coda.croodaceouscraft.init.CroodsBlocks;
import mod.coda.croodaceouscraft.init.CroodsEntities;
import mod.coda.croodaceouscraft.init.CroodsItems;
import mod.coda.croodaceouscraft.util.ClientEventBusSubscriber;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Croods.MOD_ID)
public class Croods {
    public static final String MOD_ID = "croodaceouscraft";

    public Croods() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::registerClient);
        bus.addListener(this::registerCommon);

        CroodsItems.REGISTER.register(bus);
        CroodsBlocks.REGISTER.register(bus);
        CroodsEntities.REGISTER.register(bus);
    }

    private void registerEntityAttributes() {
        GlobalEntityTypeAttributes.put(CroodsEntities.JACKROBAT.get(), JackrobatEntity.registerAttributes().create());
    }

    private void registerCommon(FMLCommonSetupEvent event) {
        registerEntityAttributes();
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEventBusSubscriber.clientSetup();
    }
}
