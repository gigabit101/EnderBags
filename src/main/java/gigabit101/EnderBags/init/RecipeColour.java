package gigabit101.EnderBags.init;

import gigabit101.EnderBags.items.ItemEnderBag;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by Gigabit101 on 06/05/2016.
 */

public class RecipeColour implements IRecipe
{
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn)
    {
        ItemStack itemStack = null;
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();

        for (int i = 0; i < inv.getSizeInventory(); ++i)
        {
            ItemStack currentStack = inv.getStackInSlot(i);

            if (currentStack != null)
            {
                if (currentStack.getItem() instanceof ItemEnderBag)
                {
                    if (itemStack != null)
                    {
                        return false;
                    }

                    itemStack = currentStack;
                }
                else
                {
                    if (currentStack.getItem() != Items.DYE)
                    {
                        return false;
                    }

                    arrayList.add(currentStack);
                }
            }
        }
        return itemStack != null && !arrayList.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv)
    {
        ItemStack itemStack = null;
        ItemEnderBag itemBag = null;
        int newcolour = 0;
        int i = 0;

        for (i = 0; i < inv.getSizeInventory(); ++i)
        {
            ItemStack currentStack = inv.getStackInSlot(i);
            if (currentStack != null)
            {
                if (currentStack.getItem() instanceof ItemEnderBag)
                {
                    itemBag = (ItemEnderBag) currentStack.getItem();

                    if (itemStack != null)
                    {
                        return null;
                    }
                    itemStack = currentStack.copy();
                    itemStack.stackSize = 1;
                }
                else
                {
                    if (currentStack.getItem() != Items.DYE)
                    {
                        return null;
                    }
                    else
                    {
                        int dyecolour = currentStack.getItemDamage();
                        EnumDyeColor test = EnumDyeColor.byMetadata(dyecolour);
                        newcolour = test.getDyeDamage();
                    }
                }
            }
        }

        if (itemBag == null)
        {
            return null;
        }
        else
        {
            itemStack.setItemDamage(newcolour);
            ItemStack outputstack = itemStack;
            return outputstack;
        }
    }

    @Override
    public int getRecipeSize()
    {
        return 10;
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        return null;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv)
    {
        int i = 0;
        for (i = 0; i < inv.getSizeInventory(); ++i)
        {
            inv.decrStackSize(i, 1);
        }
        return new ItemStack[0];
    }
}