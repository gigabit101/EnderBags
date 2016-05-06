package gigabit101.EnderBags;

import gigabit101.EnderBags.container.ContainerEnderBag;
import gigabit101.EnderBags.gui.GuiEnderBag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Gigabit101 on 06/05/2016.
 */

public class GuiHandler implements IGuiHandler
{
    public static int bagID = 0;
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == bagID)
        {
            return new ContainerEnderBag(player);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == bagID)
        {
            return new GuiEnderBag(player);
        }
        return null;
    }
}
