package gigabit101.EnderBags.inventory;

import gigabit101.EnderBags.init.ModItems;
import gigabit101.EnderBags.items.ItemEnderBag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

/**
 * Created by Gigabit101 on 03/05/2016.
 */
public class InventoryEnderBag implements IInventory
{
    private static final ItemStack[] FALLBACK_INVENTORY = new ItemStack[1];

    EntityPlayer player;
    int slot;
    ItemStack[] stacks = null;

    boolean invPushed = false;
    ItemStack storedInv = null;

    public InventoryEnderBag(EntityPlayer player, int slot)
    {
        this.player = player;
        this.slot = slot;
    }

    public static boolean isBag(ItemStack stack)
    {
        return stack != null && stack.getItem() == ModItems.enderbag;
    }

    ItemStack getStack()
    {
        ItemStack stack = player.inventory.getStackInSlot(slot);
        if(stack != null)
            storedInv = stack;
        return stack;
    }

    ItemStack[] getInventory()
    {
        if(stacks != null)
            return stacks;

        ItemStack stack = getStack();
        if(isBag(getStack())) {
            stacks = ItemEnderBag.loadStacks(stack);
            return stacks;
        }

        return FALLBACK_INVENTORY;
    }

    public void pushInventory()
    {
        if(invPushed)
            return;

        ItemStack stack = getStack();
        if(stack == null)
            stack = storedInv;

        if(stack != null) {
            ItemStack[] inv = getInventory();
            ItemEnderBag.setStacks(stack, inv);
        }

        invPushed = true;
    }

    @Override
    public int getSizeInventory()
    {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        return getInventory()[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j)
    {
        ItemStack[] inventorySlots = getInventory();
        if (inventorySlots[i] != null) {
            ItemStack stackAt;

            if (inventorySlots[i].stackSize <= j)
            {
                stackAt = inventorySlots[i];
                inventorySlots[i] = null;
                return stackAt;
            } else {
                stackAt = inventorySlots[i].splitStack(j);

                if (inventorySlots[i].stackSize == 0)
                    inventorySlots[i] = null;

                return stackAt;
            }
        }
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        ItemStack[] inventorySlots = getInventory();
        inventorySlots[i] = itemstack;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        return isBag(getStack());
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void markDirty() {
        // NO-OP
    }

    @Override
    public String getName() {
        return "enderbag";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }
}
