package gigabit101.EnderBags.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Created by Gigabit101 on 06/05/2016.
 */
public class ModRecipes
{
    public static void init()
    {
        addColourRecipes();
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderbag), "WSW", "WCW", "WWW", 'S', Items.STRING, 'C', new ItemStack(Blocks.ENDER_CHEST), 'W', new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE));
    }

    static void addColourRecipes()
    {
        CraftingManager.getInstance().getRecipeList().add(new RecipeColour());
    }
}
