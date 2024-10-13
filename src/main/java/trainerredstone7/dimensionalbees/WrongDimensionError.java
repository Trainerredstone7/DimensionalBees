package trainerredstone7.dimensionalbees;

import forestry.api.core.IErrorState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class WrongDimensionError implements IErrorState {
	
	//set this right before the error state is registered (to the next available id)
	//This is important, if it's wrong it will show the wrong error
	public static short id;

	@Override
	public short getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getUniqueName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnlocalizedDescription() {
		// TODO Auto-generated method stub
		return "error.wrong_dimension.desc";
	}

	@Override
	public String getUnlocalizedHelp() {
		// TODO Auto-generated method stub
		return "error.wrong_dimension.help";
	}

	@Override
	public void registerSprite() {
		// TODO Auto-generated method stub

	}

	@Override
	public TextureAtlasSprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

}
