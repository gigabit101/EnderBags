package gigabit101.EnderBags.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Gigabit101 on 06/05/2016.
 */

public class ConfigEnderBags
{
    private static ConfigEnderBags instance = null;
    public static String CATEGORY_RECIPE = "RECIPE";

    public static boolean disableEnderBagDyes;
    public static boolean disableEnderBagRecipe;

    public static Configuration config;

    private ConfigEnderBags(File configFile)
    {
        config = new Configuration(configFile);
        config.load();

        ConfigEnderBags.Configs();

        config.save();
    }

    public static ConfigEnderBags initialize(File configFile)
    {
        if (instance == null)
            instance = new ConfigEnderBags(configFile);
        else
            throw new IllegalStateException("Cannot initialize EnderBags Config twice");
        return instance;
    }

    public static ConfigEnderBags instance()
    {
        if (instance == null)
        {
            throw new IllegalStateException("Instance of EnderBags Config requested before initialization");
        }
        return instance;
    }

    public static void Configs()
    {
        disableEnderBagDyes = config.get(CATEGORY_RECIPE,"Disable Enderbags from being dyes",  false, "set to true to remove dye recipes from EnderBags").getBoolean();
        disableEnderBagRecipe = config.get(CATEGORY_RECIPE,"Disable Enderbags Recipe",  false, "set to true to remove recipe from EnderBags").getBoolean();

        if (config.hasChanged())
        {
            config.save();
        }
    }
}
