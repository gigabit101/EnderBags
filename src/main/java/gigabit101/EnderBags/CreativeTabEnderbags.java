package gigabit101.EnderBags;

import gigabit101.EnderBags.init.ModItems;
import gigabit101.EnderBags.lib.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Travis on 06/05/2016.
 */

public class CreativeTabEnderbags extends CreativeTabs
{
    public static CreativeTabEnderbags instance = new CreativeTabEnderbags();

    public CreativeTabEnderbags()
    {
        super(ModInfo.MOD_ID);
    }

    @Override
    public Item getTabIconItem()
    {
        return ModItems.enderbag;
    }
}
