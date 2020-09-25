package mod.coda.croodaceouscraft;

import mod.coda.croodaceouscraft.init.CroodsBlocks;
import mod.coda.croodaceouscraft.init.CroodsFeatures;
import mod.coda.croodaceouscraft.init.CroodsItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Croods.MOD_ID)
public class Croods {
    public static final String MOD_ID = "croodaceouscraft";

    public Croods() {
        float lvt_1_1_ = 2 / 3.0F;
        System.out.println(MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F));
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CroodsItems.REGISTER.register(bus);
        CroodsBlocks.REGISTER.register(bus);
        CroodsFeatures.REGISTER.register(bus);
    }
}
