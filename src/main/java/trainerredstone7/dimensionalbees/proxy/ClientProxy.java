package trainerredstone7.dimensionalbees.proxy;

import net.minecraftforge.client.ClientCommandHandler;
import trainerredstone7.dimensionalbees.CommandGetBeeUID;


public class ClientProxy extends CommonProxy {

	@Override
	public void registerCommands() {
		ClientCommandHandler.instance.registerCommand(new CommandGetBeeUID());
	}

}
