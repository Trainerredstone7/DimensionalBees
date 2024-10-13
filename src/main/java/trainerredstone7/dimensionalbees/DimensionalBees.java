package trainerredstone7.dimensionalbees;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trainerredstone7.dimensionalbees.proxy.CommonProxy;

import org.apache.logging.log4j.Logger;

@Mod(modid = DimensionalBees.MODID, name = DimensionalBees.NAME, version = DimensionalBees.VERSION, dependencies = "required-after:forestry;required-after:fermiumbooter")
@Mod.EventBusSubscriber
public class DimensionalBees
{
    public static final String MODID = "dimensionalbees";
    public static final String NAME = "Dimensional Bees";
    public static final String VERSION = "0.1";

    public static Logger logger;
    @SidedProxy(clientSide = "trainerredstone7.dimensionalbees.proxy.ClientProxy", serverSide = "trainerredstone7.dimensionalbees.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static DimensionalBees instance;

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ConfigBeeDimensionMap.generateBeeDimensionMap();
        proxy.registerCommands();
        WrongDimensionError.instance().register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
    @SubscribeEvent
    public static void syncConfig(ConfigChangedEvent.OnConfigChangedEvent event) {
    	if (event.getModID().equals(DimensionalBees.MODID)) {
    		ConfigManager.sync(DimensionalBees.MODID, Config.Type.INSTANCE);
    		ConfigBeeDimensionMap.generateBeeDimensionMap();
    	}
    }
    
//	@SubscribeEvent
//	@SideOnly(Side.CLIENT)
//	public static void handleTextureRemap(TextureStitchEvent.Pre event) {
//		WrongDimensionError.instance().registerSprite();
//		DimensionalBees.logger.info("registered sprite");
//	}
}
