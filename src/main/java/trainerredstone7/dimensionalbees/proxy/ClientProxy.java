package trainerredstone7.dimensionalbees.proxy;

import forestry.core.errors.ErrorStateRegistry;
import forestry.core.models.ModelBlockCached;
import forestry.core.models.ModelBlockCustomCached;
import forestry.core.render.TextureManagerForestry;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trainerredstone7.dimensionalbees.CommandGetBeeUID;
import trainerredstone7.dimensionalbees.DimensionalBees;
import trainerredstone7.dimensionalbees.WrongDimensionError;


public class ClientProxy extends CommonProxy {

	@Override
	public void registerCommands() {
		ClientCommandHandler.instance.registerCommand(new CommandGetBeeUID());
	}

}
