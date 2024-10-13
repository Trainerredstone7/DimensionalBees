package trainerredstone7.dimensionalbees.mixin;

import java.util.List;
import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.core.IErrorState;
import forestry.apiculture.genetics.Bee;
import trainerredstone7.dimensionalbees.DimensionalBees;
import trainerredstone7.dimensionalbees.WrongDimensionError;

@Mixin(Bee.class)
public abstract class MixinBee {
	//TODO make sure this doesn't crash at runtime when using bee house
	
	//enables adding additional error conditions for bee work
	@ModifyVariable(at = @At("STORE"), method = "getCanWork(Lforestry/api/apiculture/IBeeHousing;)Ljava/util/Set;", remap = false)
	private Set<IErrorState> checkCorrectDimension(Set<IErrorState> errors, IBeeHousing housing) {
		errors.add(new WrongDimensionError());
		DimensionalBees.logger.info(housing.getBiome().getBiomeName());
		//TODO add any other error types (ex. dimension errors) to the errors Set
		return errors;
	}
	//enables adding information about dimension restrictions to tooltip
	//TODO make sure this works
	@ModifyVariable(at = @At("TAIL"), method = "addTooltip(Ljava/util/List;)V", remap = false, argsOnly = true)
	private List<String> onAddTooltip(List<String> list) {
		list.add("test");
		return list;
	}
}
