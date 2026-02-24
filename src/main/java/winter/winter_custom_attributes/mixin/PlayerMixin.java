package winter.winter_custom_attributes.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import winter.winter_custom_attributes.attributes.AttributesRegistry;
import winter.winter_custom_attributes.event.EventUtils;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    private Player self = (Player) (Object) this;

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "getBaseExperienceReward", at = @At("RETURN"), cancellable = true)
    public void mixinGetBaseExperienceReward(CallbackInfoReturnable<Integer> cir) {
        if(self instanceof Player player) {
            cir.setReturnValue((int)(cir.getReturnValue() * EventUtils.getSafeAttributeValue(player, AttributesRegistry.generic_xp_drop_on_death_mult, 1)));
        } else {
            cir.setReturnValue(cir.getReturnValue());
        }
    }
}
