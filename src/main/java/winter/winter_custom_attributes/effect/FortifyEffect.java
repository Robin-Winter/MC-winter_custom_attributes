package winter.winter_custom_attributes.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import winter.winter_custom_attributes.WinterCustomAttributes;
import winter.winter_custom_attributes.attributes.AttributesRegistry;

public class FortifyEffect extends MobEffect {

    protected FortifyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onEffectAdded(LivingEntity livingEntity, int amplifier) {
        this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath("minecraft","generic.armor") ,livingEntity.getAttributeValue(AttributesRegistry.fortify_armor), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath("minecraft","generic.armor_toughness") ,livingEntity.getAttributeValue(AttributesRegistry.fortify_toughness), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.MAX_ABSORPTION, ResourceLocation.fromNamespaceAndPath("minecraft","generic.max_absorption") ,livingEntity.getAttributeValue(AttributesRegistry.fortify_absorption), AttributeModifier.Operation.ADD_VALUE);
    }
}
