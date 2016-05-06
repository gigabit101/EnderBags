package gigabit101.EnderBags.container;

import gigabit101.EnderBags.inventory.InventoryEnderBag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

/**
 * Created by Gigabit101 on 03/05/2016.
 */

public class ContainerEnderBag extends ContainerBase
{
    public InventoryEnderBag inv;
    public EntityPlayer player;

    public ContainerEnderBag(EntityPlayer player)
    {
        super();
        this.player = player;

        int slot = player.inventory.currentItem;
        inv = new InventoryEnderBag(player, slot);

        int j;
        int k;

        for (j = 0; j < 8; ++j)
        {
            for (k = 0; k < 13; ++k)
            {
                this.addSlotToContainer(new Slot(inv, k + j * 13, 12 + k * 18, 5 + j * 18));
            }
        }

        for (j = 0; j < 3; ++j)
        {
            for (k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 48 + k * 18, 152 + j * 18));
            }
        }

        for (j = 0; j < 9; ++j)
        {
            if(player.inventory.currentItem == j)
            {
                this.addSlotToContainer(new SlotLocked(player.inventory, j, 48 + j * 18, 210));
            }
            else
            {
                addSlotToContainer(new Slot(player.inventory, j, 48 + j * 18, 210));
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        boolean can = inv.isUseableByPlayer(player);
        if(!can)
        {
            onContainerClosed(player);
        }
        return can;
    }

    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        inv.pushInventory();
    }
}
