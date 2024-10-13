package trainerredstone7.dimensionalbees.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;
import trainerredstone7.dimensionalbees.DimensionalBees;

@Mixin(Block.class)
public abstract class MixinBlock extends Impl<Block> {

	//enables adding additional error conditions for bee work
	@Inject(at = @At("RETURN"), method = "breakBlock(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;)V")
	private void test(CallbackInfo ci) {
		DimensionalBees.logger.info("injection into Block successful!");
	}
}
