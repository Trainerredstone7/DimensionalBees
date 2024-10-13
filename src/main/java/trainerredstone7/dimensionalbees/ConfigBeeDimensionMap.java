package trainerredstone7.dimensionalbees;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Ignore;
import net.minecraftforge.common.config.Config.LangKey;

@Config(modid = "dimensionalbees", category = "general")
public class ConfigBeeDimensionMap {
	
	//the name to use should typically just be the name (in english) of the species
	@LangKey(value = "dimensionalbees.config.beeDimensions")
	@Comment(value = {"A list of bees and the dimensions they can work in.",
			"Each entry should start with the bee species UID (obtainable with /buid while holding a bee)",
			"and be followed by a comma- or space-separated list of dimension IDs.",
			"Bees not in this list are unaffected.",
			"Ex. \"forestry.speciesForest, -1, 1\" would make the Forest species only work in the nether and end."})
	public static String[] beeDimensions = {};
	
	@Ignore
	public static Map<String, Set<Integer>> beeDimensionMap;
	
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
