package trainerredstone7.dimensionalbees;

import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.common.DimensionManager;

public class DimensionNameKey {
	private Map<Integer,String> dimsToNames = new HashMap<Integer,String>();
	
	public DimensionNameKey() {
		for(int dim:DimensionManager.getStaticDimensionIDs()) {
			DimensionManager.createProviderFor(dim).getDimensionType();
		}
		
	}
}
