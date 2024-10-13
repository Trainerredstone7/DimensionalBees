package trainerredstone7.dimensionalbees;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Logger;

@Mod(modid = DimensionalBees.MODID, name = DimensionalBees.NAME, version = DimensionalBees.VERSION)
public class DimensionalBees
{
    public static final String MODID = "dimensionalbees";
    public static final String NAME = "Dimensional Bees";
    public static final String VERSION = "0.1";

    public static Logger logger;

    @Mod.Instance
    public static DimensionalBees instance;

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ConfigBeeValidDimensions.generateBeeDimensionMap();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
    
    @SubscribeEvent
    public static void syncConfig(ConfigChangedEvent.OnConfigChangedEvent event) {
    	if (event.getModID().equals(DimensionalBees.MODID)) {
    		ConfigManager.sync(DimensionalBees.MODID, Config.Type.INSTANCE);
    		ConfigBeeValidDimensions.generateBeeDimensionMap();
    	}
    }
}
