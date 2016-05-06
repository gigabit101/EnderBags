package gigabit101.EnderBags.proxy;

import gigabit101.EnderBags.init.ModItems;
import gigabit101.EnderBags.items.IColorable;
import gigabit101.EnderBags.items.ItemEnderBag;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Gigabit101 on 06/05/2016.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenders()
    {
        int i;
        for (i = 0; i < ItemEnderBag.COLOURS.length; ++i)
        {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModItems.enderbag, i, new ModelResourceLocation("enderbags" + ":" + "enderbag", "inventory"));
        }

        ItemColors items = Minecraft.getMinecraft().getItemColors();

        items.registerItemColorHandler(new IItemColor()
        {
            @Override
            public int getColorFromItemstack(ItemStack stack, int tintIndex) {
                Item item = stack.getItem();
                if (item instanceof IColorable)
                {
                    return ((IColorable) item).getColorFromItemStack(stack, tintIndex);
                }
                else
                {
                    return 0xFFFFFF;
                }
            }
        }, ModItems.enderbag);
    }
}
