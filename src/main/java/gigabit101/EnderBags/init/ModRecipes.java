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
        ItemStack bags = new ItemStack(ModItems.enderbag, 1, OreDictionary.WILDCARD_VALUE);

        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 0), bags, "dyeWhite");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 1), bags, "dyeOrange");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 2), bags, "dyeMagenta");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 3), bags, "dyeLightBlue");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 4), bags, "dyeYellow");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 5), bags, "dyeLime");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 6), bags, "dyePink");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 7), bags, "dyeGray");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 8), bags, "dyeLightGray");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 9), bags, "dyeCyan");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 10), bags, "dyePurple");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 11), bags, "dyeBlue");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 12), bags, "dyeBrown");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 13), bags, "dyeGreen");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 14), bags, "dyeRed");
        addShapelessOreRecipe(new ItemStack(ModItems.enderbag, 1, 15), bags, "dyeBlack");
    }

    public static void addShapelessOreRecipe(ItemStack outputItemStack, Object... objectInputs)
    {
        CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(outputItemStack, objectInputs));
    }
}
