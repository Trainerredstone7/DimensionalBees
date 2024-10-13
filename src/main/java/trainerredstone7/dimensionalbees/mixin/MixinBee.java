package trainerredstone7.dimensionalbees.mixin;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.core.IErrorState;
import forestry.apiculture.genetics.Bee;
import forestry.core.genetics.IndividualLiving;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.DimensionManager;
import trainerredstone7.dimensionalbees.ConfigBeeDimensionMap;
import trainerredstone7.dimensionalbees.WrongDimensionError;

@Mixin(Bee.class)
public abstract class MixinBee extends IndividualLiving implements IBee {
	
	//enables adding additional error conditions for bee work
	@ModifyVariable(at = @At("STORE"), method = "getCanWork(Lforestry/api/apiculture/IBeeHousing;)Ljava/util/Set;", remap = false)
	private Set<IErrorState> checkCorrectDimension(Set<IErrorState> errors, IBeeHousing housing) {
		if (ConfigBeeDimensionMap.beeDimensionMap.containsKey(getIdent())) {
			int dim = housing.getWorldObj().provider.getDimension();
			if (!ConfigBeeDimensionMap.beeDimensionMap.get(getIdent()).contains(dim)) {
				errors.add(WrongDimensionError.instance());
			}
		}
		return errors;
	}
	//enables adding information about dimension restrictions to tooltip
	@ModifyVariable(at = @At("TAIL"), method = "addTooltip(Ljava/util/List;)V", remap = false, argsOnly = true)
	private List<String> onAddTooltip(List<String> list) {
		if (ConfigBeeDimensionMap.beeDimensionMap.containsKey(getIdent())) {
			Set<Integer> validDimensions = ConfigBeeDimensionMap.beeDimensionMap.get(getIdent());
			String validDimensionsString = "";
			for (int dim:validDimensions) {
				String dimensionName = DimensionManager.getProviderType(dim).getName();
				validDimensionsString = validDimensionsString.concat(dimensionName + ", ");
			}
			//remove final comma and space
			validDimensionsString = validDimensionsString.substring(0,validDimensionsString.length()-2);
			TextComponentTranslation header = new TextComponentTranslation("dimensionalbees.tooltips.validdimensions");
			header.getStyle().setColor(TextFormatting.AQUA);
			list.add(header.getFormattedText());
			list.add(validDimensionsString);
//			I18n.format("my.language.key", TextFormatting.AQUA, TextFormatting.RESET)
//			validDimensionsString = new TextComponentTranslation("dimensionalbees.tooltips.validdimensions").appendText(validDimensionsString).getFormattedText();
//			list.add(validDimensionsString);
		}
		return list;
	}
}
