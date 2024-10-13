package trainerredstone7.dimensionalbees;

import forestry.api.core.ForestryAPI;
import forestry.api.core.IErrorState;
import forestry.core.render.TextureManagerForestry;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WrongDimensionError implements IErrorState {
	
	//set this right before the error state is registered (to the next available id)
	//This is important, if it's wrong it will show the wrong error
	private short id;
	private static WrongDimensionError instance;
	
	@SideOnly(Side.CLIENT)
	private TextureAtlasSprite texture;
	
	private WrongDimensionError() {}
	
	public static WrongDimensionError instance() {
		if (instance == null) {
			instance = new WrongDimensionError();
		}
		return instance;
	}
	
	public void register() {
		id = (short) ForestryAPI.errorStateRegistry.getErrorStates().size();
		ForestryAPI.errorStateRegistry.registerErrorState(instance());
	}
	
	@Override
	public short getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getUniqueName() {
		// TODO Auto-generated method stub
		return DimensionalBees.MODID + ":wrong_dimension";
	}

	@Override
	public String getUnlocalizedDescription() {
		// TODO Auto-generated method stub
		return "dimensionalbees.error.wrong_dimension.desc";
	}

	@Override
	public String getUnlocalizedHelp() {
		// TODO Auto-generated method stub
		return "dimensionalbees.error.wrong_dimension.help";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerSprite() {
		ResourceLocation location = new ResourceLocation(DimensionalBees.MODID, "wrong_dimension");
		texture = TextureManagerForestry.getInstance().registerGuiSprite(location);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public TextureAtlasSprite getSprite() {
		return texture;
	}

}
