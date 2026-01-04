package winter.winter_custom_attributes.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import winter.winter_custom_attributes.attributes.AttributesRegistry;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "createLivingAttributes", at = @At("RETURN"), cancellable = true)
    private static void mixinCreateLivingAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> returnValue) {
        AttributeSupplier.Builder result = returnValue.getReturnValue();

        for(Holder<Attribute> atr : AttributesRegistry.ATTRIBUTES.getEntries()) {
            result.add(atr);
        }

        returnValue.setReturnValue(result);
    }

}
