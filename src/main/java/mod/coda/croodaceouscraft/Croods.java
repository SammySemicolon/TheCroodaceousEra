package mod.coda.croodaceouscraft;

import mod.coda.croodaceouscraft.init.CroodsBlocks;
import mod.coda.croodaceouscraft.init.CroodsItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Croods.MOD_ID)
@Mod.EventBusSubscriber(modid = Croods.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Croods {

    public static final String MOD_ID = "croodaceouscraft";
    public static Croods instance;

    public Croods() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);


        CroodsItems.REGISTER.register(modEventBus);
        CroodsBlocks.REGISTER.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLCommonSetupEvent event) {
    }

    public final static ItemGroup GROUP = new ItemGroup("croods_item_group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CroodsItems.CROODACEOUS_SAND.get());
        }
    };
}

