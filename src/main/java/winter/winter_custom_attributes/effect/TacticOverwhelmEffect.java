package winter.winter_custom_attributes.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.puffish.attributesmod.api.PuffishAttributes;
import winter.winter_custom_attributes.attributes.AttributesRegistry;

public class TacticOverwhelmEffect extends MobEffect {

    protected TacticOverwhelmEffect(MobEffectCategory category, int color) {
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
        this.addAttributeModifier(AttributesRegistry.meele_crit_chance, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","meele_crit_chance"), livingEntity.getAttributeValue(AttributesRegistry.tactic_overwhelm_meele_crit_chance), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.ranged_crit_chance, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","ranged_crit_chance"), livingEntity.getAttributeValue(AttributesRegistry.tactic_overwhelm_ranged_crit_chance), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.meele_crit_damage, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","meele_crit_damage"), livingEntity.getAttributeValue(AttributesRegistry.tactic_overwhelm_meele_crit_damage), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.ranged_crit_damage, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","ranged_crit_damage"), livingEntity.getAttributeValue(AttributesRegistry.tactic_overwhelm_ranged_crit_damage), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PuffishAttributes.MELEE_DAMAGE, ResourceLocation.fromNamespaceAndPath("puffish_attributes","melee_damage") ,livingEntity.getAttributeValue(AttributesRegistry.tactic_overwhelm_meele_damage), AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(PuffishAttributes.RANGED_DAMAGE, ResourceLocation.fromNamespaceAndPath("puffish_attributes","ranged_damage") ,livingEntity.getAttributeValue(AttributesRegistry.tactic_overwhelm_ranged_damage), AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(PuffishAttributes.ARMOR_SHRED, ResourceLocation.fromNamespaceAndPath("puffish_attributes","armor_shred") ,livingEntity.getAttributeValue(AttributesRegistry.tactic_overwhelm_armor_shred), AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }
}
