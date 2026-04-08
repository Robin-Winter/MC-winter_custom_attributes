package winter.winter_custom_attributes.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.extensions.IBlockExtension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import winter.winter_custom_attributes.Config;
import winter.winter_custom_attributes.event.TagRegistry;

@Mixin(IBlockExtension.class)
public interface IBlockExtensionMixin {

    @Inject(method = "isPortalFrame", at = @At("HEAD"), cancellable = true)
    default void mixinUse(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(state.is(Config.getNetherPortalBlock()));
    }
}
