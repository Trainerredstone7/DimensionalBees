package trainerredstone7.dimensionalbees;

import java.util.ArrayList;
import java.util.List;

import forestry.api.genetics.IIndividual;
import forestry.core.utils.GeneticsUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.IClientCommand;

public class CommandGetBeeUID extends CommandBase implements IClientCommand {

	@Override
	public String getName() {
		return "beeuid";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/beeuid";
	}
	
	@Override
    public List<String> getAliases() {
        List<String> list = new ArrayList<String>();
        list.add("beeuid");
        list.add("buid");
        return list;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender,
			String[] args) throws CommandException {
		if (sender instanceof EntityPlayer) {
			ItemStack hand = ((EntityPlayer) sender).getHeldItemMainhand();
			IIndividual geneticItem = GeneticsUtil.getGeneticEquivalent(hand);
			if (geneticItem != null) {
				sender.sendMessage(new TextComponentString(geneticItem.getIdent()));
			}
			else {
				sender.sendMessage(new TextComponentTranslation("dimensionalbees.messages.nogeneinfo"));
			}
		}

	}

	@Override
	public boolean allowUsageWithoutPrefix(ICommandSender sender,
			String message) {
		// TODO Auto-generated method stub
		return false;
	}

}
