package gigabit101.EnderBags.init;

import gigabit101.EnderBags.items.ItemEnderBag;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gigabit101 on 06/05/2016.
 */

public class ModItems
{
    public static Item enderbag;

    public static void init()
    {
        enderbag = new ItemEnderBag();
        GameRegistry.register(enderbag);

    }
}
