package winter.winter_custom_attributes.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.puffish.attributesmod.api.PuffishAttributes;
import winter.winter_custom_attributes.attributes.AttributesRegistry;

public class ScorchingEffect extends MobEffect {

    protected ScorchingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof Player player) {
            player.causeFoodExhaustion(0.005F * (float)(amplifier + 1));
        }
        return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onEffectAdded(LivingEntity livingEntity, int amplifier) {
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath("minecraft","generic.movement_speed") ,-0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(PuffishAttributes.STAMINA, ResourceLocation.fromNamespaceAndPath("puffish_attributes","stamina") ,-0.2 * (1+amplifier), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }
}
