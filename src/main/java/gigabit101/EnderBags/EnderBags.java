package gigabit101.EnderBags;

import gigabit101.EnderBags.init.ModItems;
import gigabit101.EnderBags.init.ModRecipes;
import gigabit101.EnderBags.items.IColorable;
import gigabit101.EnderBags.items.ItemEnderBag;
import gigabit101.EnderBags.lib.ModInfo;
import gigabit101.EnderBags.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Gigabit101 on 06/05/2016.
 */

@Mod(name = ModInfo.MOD_NAME, modid = ModInfo.MOD_ID, version = ModInfo.MOD_VERSION)
public class EnderBags
{
    @Mod.Instance
    public static EnderBags INSTANCE;

    @SidedProxy(clientSide = "gigabit101.EnderBags.proxy.ClientProxy", serverSide = "gigabit101.EnderBags.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModItems.init();
        ModRecipes.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(ModInfo.MOD_ID, new GuiHandler());
        proxy.registerRenders();
    }
}
