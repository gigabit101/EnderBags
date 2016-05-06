package gigabit101.EnderBags.init;

import gigabit101.EnderBags.config.ConfigEnderBags;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Gigabit101 on 06/05/2016.
 */
public class ModRecipes
{
    public static void init()
    {
        if(!ConfigEnderBags.disableEnderBagDyes)
        {
            CraftingManager.getInstance().getRecipeList().add(new RecipeColour());
        }
        if(!ConfigEnderBags.disableEnderBagRecipe)
        {
            GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderbag), "WSW", "WCW", "WWW", 'S', Items.STRING, 'C', new ItemStack(Blocks.ENDER_CHEST), 'W', new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE));
        }
    }
}
