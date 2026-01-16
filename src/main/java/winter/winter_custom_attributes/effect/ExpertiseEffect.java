package winter.winter_custom_attributes.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.Tags;
import net.puffish.attributesmod.api.PuffishAttributes;
import winter.winter_custom_attributes.attributes.AttributesRegistry;
import winter.winter_custom_attributes.event.EventUtils;

import java.util.ArrayList;
import java.util.List;

public class ExpertiseEffect extends MobEffect {

    protected ExpertiseEffect(MobEffectCategory category, int color) {
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
        this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath("minecraft","generic.armor") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_armor), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath("minecraft","generic.armor_toughness") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_toughness), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.MAX_ABSORPTION, ResourceLocation.fromNamespaceAndPath("minecraft","generic.max_absorption") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_absorption), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath("minecraft","generic.movement_speed") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_movement_mult), AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocation.fromNamespaceAndPath("minecraft","generic.fall_damage_multiplier") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_falldamage_mult), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.OXYGEN_BONUS, ResourceLocation.fromNamespaceAndPath("minecraft","generic.oxygen_bonus") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_oxygen), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PuffishAttributes.FORTUNE, ResourceLocation.fromNamespaceAndPath("puffish_attributes","fortune") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_fortune), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PuffishAttributes.STEALTH, ResourceLocation.fromNamespaceAndPath("puffish_attributes","stealth") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_stealth), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PuffishAttributes.NATURAL_REGENERATION, ResourceLocation.fromNamespaceAndPath("puffish_attributes","natural_regeneration") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_natural_regeneration), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PuffishAttributes.STAMINA, ResourceLocation.fromNamespaceAndPath("puffish_attributes","stamina") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_stamina), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.slow_meele_inflict_chance, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","slow_meele_inflict_chance") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_slow_chance), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.slow_ranged_inflict_chance, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","slow_ranged_inflict_chance") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_slow_chance), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.burn_meele_inflict_chance, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","burn_meele_inflict_chance") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_burn_chance), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.burn_ranged_inflict_chance, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","burn_ranged_inflict_chance") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_burn_chance), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.poison_meele_inflict_chance, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","poison_meele_inflict_chance") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_poison_chance), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(AttributesRegistry.poison_ranged_inflict_chance, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes","poison_ranged_inflict_chance") ,livingEntity.getAttributeValue(AttributesRegistry.expertise_poison_chance), AttributeModifier.Operation.ADD_VALUE);
    }

    public static List<TagKey<Biome>> getViableBiomes(LivingEntity livingEntity) {
        List<TagKey<Biome>> biomes = new ArrayList<>();
        if(EventUtils.getSafeAttributeValue(livingEntity, AttributesRegistry.expertise_in_taiga) == 1) {
            biomes.add(Tags.Biomes.IS_TAIGA);
        }
        if(EventUtils.getSafeAttributeValue(livingEntity, AttributesRegistry.expertise_in_jungle) == 1) {
            biomes.add(Tags.Biomes.IS_JUNGLE);
        }
        if(EventUtils.getSafeAttributeValue(livingEntity, AttributesRegistry.expertise_in_desert) == 1) {
            biomes.add(Tags.Biomes.IS_DESERT);
        }
        if(EventUtils.getSafeAttributeValue(livingEntity, AttributesRegistry.expertise_in_badlands) == 1) {
            biomes.add(Tags.Biomes.IS_BADLANDS);
        }
        if(EventUtils.getSafeAttributeValue(livingEntity, AttributesRegistry.expertise_in_ocean) == 1) {
            biomes.add(Tags.Biomes.IS_OCEAN);
            biomes.add(Tags.Biomes.IS_BEACH);
        }
        if(EventUtils.getSafeAttributeValue(livingEntity, AttributesRegistry.expertise_in_forest) == 1) {
            biomes.add(Tags.Biomes.IS_FOREST);
        }
        if(EventUtils.getSafeAttributeValue(livingEntity, AttributesRegistry.expertise_in_mountain) == 1) {
            biomes.add(Tags.Biomes.IS_MOUNTAIN);
            biomes.add(Tags.Biomes.IS_HILL);
        }
        return biomes;
    }
}
