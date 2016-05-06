package gigabit101.EnderBags;

import gigabit101.EnderBags.config.ConfigEnderBags;
import gigabit101.EnderBags.init.ModItems;
import gigabit101.EnderBags.init.ModRecipes;
import gigabit101.EnderBags.lib.ModInfo;
import gigabit101.EnderBags.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.io.File;

/**
 * Created by Gigabit101 on 06/05/2016.
 */

@Mod(name = ModInfo.MOD_NAME, modid = ModInfo.MOD_ID, version = ModInfo.MOD_VERSION)
public class EnderBags
{
    @Mod.Instance
    public static EnderBags INSTANCE;

    public static ConfigEnderBags config;

    @SidedProxy(clientSide = "gigabit101.EnderBags.proxy.ClientProxy", serverSide = "gigabit101.EnderBags.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preinit(FMLPreInitializationEvent event)
    {
        String path = event.getSuggestedConfigurationFile().getAbsolutePath().replace(ModInfo.MOD_ID, "QuantumStorage");
        config = ConfigEnderBags.initialize(new File(path));
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModItems.init();
        ModRecipes.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(ModInfo.MOD_ID, new GuiHandler());
        proxy.registerRenders();
    }
}
