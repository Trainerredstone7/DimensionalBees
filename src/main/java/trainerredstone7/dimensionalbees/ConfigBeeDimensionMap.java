package trainerredstone7.dimensionalbees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.IBee;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config.Ignore;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = "dimensionalbees", category = "general")
public class ConfigBeeDimensionMap {
	
	//the name to use should typically just be the name (in english) of the species
	@LangKey(value = "dimensionalbees.config.beeDimensions")
	public static String[] beeDimensions = {};
	
	@Ignore
	public static Map<String, Set<Integer>> beeDimensionMap;
	
	public boolean canBeeWorkInDimension(IBee bee, int dim) {
		return beeDimensionMap.get(bee.getIdent()).contains(dim);
	}
	
	public static void generateBeeDimensionMap() {
		beeDimensionMap = new HashMap<String, Set<Integer>>();
		for (String s:beeDimensions) {
			StringTokenizer tokenizer = new StringTokenizer(s, ", ");
			try {
				String beeName = tokenizer.nextToken();
				Set<Integer> dimensions = new TreeSet<Integer>(); 
				while (tokenizer.hasMoreElements()) {
					dimensions.add(Integer.parseInt(tokenizer.nextToken()));
				}
				beeDimensionMap.putIfAbsent(beeName, dimensions);
			} catch (NoSuchElementException | NumberFormatException e) {
				DimensionalBees.logger.error("Error parsing config, skipping entry: \""+s+"\"");
			}
		}
	}
	

}
