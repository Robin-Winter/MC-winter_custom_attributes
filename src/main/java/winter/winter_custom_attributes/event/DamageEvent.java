package winter.winter_custom_attributes.event;

import com.llamalad7.mixinextras.sugar.SugarBridge;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.projectile.Projectile;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import winter.winter_custom_attributes.WinterCustomAttributes;
import winter.winter_custom_attributes.attributes.AttributesRegistry;
import winter.winter_custom_attributes.effect.ModEffects;
import winter.winter_custom_attributes.enums.RangeType;

@EventBusSubscriber(modid = WinterCustomAttributes.MODID)
public class DamageEvent extends EventUtils {

    @SubscribeEvent
    public  static void onLivingIncomingDamageEvent(LivingIncomingDamageEvent event) {
        // Damaged by a living Entity
        if(event.getSource().getEntity() instanceof LivingEntity livingSource) {
            // Determine attack type
            RangeType rangeType = RangeType.UNKNOWN;
            if(event.getSource().isDirect()) {
                rangeType = RangeType.MEELE;
            } else if(event.getSource().getDirectEntity() instanceof Projectile) {
                rangeType = RangeType.RANGED;
            }

            // Applying onHurt Effects first
            applyOnHurtGainEffects(livingSource, event.getEntity(), rangeType);
            applyOnHurtInflictEffects(livingSource, event.getEntity(), rangeType);

            // Applying onHit Effects second
            applyOnHitGainEffects(livingSource, event.getEntity(), rangeType);
            applyOnHitInflictEffects(livingSource, event.getEntity(), rangeType);

            // Checking for Crits
            if(rangeType != RangeType.UNKNOWN) {
                double critChance = rangeType == RangeType.MEELE ? getSafeAttributeValue(livingSource,AttributesRegistry.meele_crit_chance) : rangeType == RangeType.RANGED ? getSafeAttributeValue(livingSource,AttributesRegistry.ranged_crit_chance) : 0;
                if (livingSource.getRandom().nextDouble() < critChance) {
                    if (rangeType == RangeType.MEELE) {
                        event.setAmount((float) (event.getAmount() * Math.max(1, getSafeAttributeValue(livingSource,AttributesRegistry.meele_crit_damage))));
                        livingSource.level().playSound(null, livingSource.getX(), livingSource.getY(), livingSource.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, livingSource.getSoundSource(), 1.0F, 1.0F);
                    } else if (rangeType == RangeType.RANGED) {
                        event.setAmount((float) (event.getAmount() * Math.max(1, getSafeAttributeValue(livingSource,AttributesRegistry.ranged_crit_damage))));
                        livingSource.level().playSound(null, livingSource.getX(), livingSource.getY(), livingSource.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, livingSource.getSoundSource(), 1.0F, 1.0F);
                    }
                }
            }
        }
    }

    protected static void applyOnHitInflictEffects(LivingEntity attacker, LivingEntity defender, RangeType rangeType) {
        // Meele
        if(rangeType == RangeType.MEELE) {
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.slow_meele_inflict_chance)) {
                defender.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)getSafeAttributeValue(defender,AttributesRegistry.slow_duration), (int)getSafeAttributeValue(defender,AttributesRegistry.slow_strength), false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.poison_meele_inflict_chance)) {
                defender.addEffect(new MobEffectInstance(MobEffects.POISON, (int)getSafeAttributeValue(defender,AttributesRegistry.poison_duration), (int)getSafeAttributeValue(defender,AttributesRegistry.poison_strength), false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.burn_meele_inflict_chance)) {
                defender.setRemainingFireTicks(160);
            }
        }

        // Ranged
        if(rangeType == RangeType.RANGED) {
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.slow_ranged_inflict_chance)) {
                defender.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)getSafeAttributeValue(defender,AttributesRegistry.slow_duration), (int)getSafeAttributeValue(defender,AttributesRegistry.slow_strength), false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.poison_ranged_inflict_chance)) {
                defender.addEffect(new MobEffectInstance(MobEffects.POISON, (int)getSafeAttributeValue(defender,AttributesRegistry.poison_duration), (int)getSafeAttributeValue(defender,AttributesRegistry.poison_strength), false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.burn_ranged_inflict_chance)) {
                defender.setRemainingFireTicks(160);
            }
        }
    }

    protected static void applyOnHitGainEffects(LivingEntity attacker, LivingEntity defender, RangeType rangeType) {
        // Meele
        if(rangeType == RangeType.MEELE) {
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.rage_meele_gain_chance)) {
                attacker.addEffect(new MobEffectInstance(ModEffects.RAGE_EFFECT, (int)getSafeAttributeValue(attacker,AttributesRegistry.rage_duration), 1, false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.tactic_hitrun_meele_gain_chance)) {
                attacker.addEffect(new MobEffectInstance(ModEffects.TACTIC_HITRUN_EFFECT, (int)getSafeAttributeValue(attacker,AttributesRegistry.tactic_hitrun_duration), 1, false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.tactic_assault_meele_gain_chance)) {
                attacker.addEffect(new MobEffectInstance(ModEffects.TACTIC_ASSAULT_EFFECT, (int)getSafeAttributeValue(attacker,AttributesRegistry.tactic_assault_duration), 1, false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.tactic_overwhelm_meele_gain_chance)) {
                attacker.addEffect(new MobEffectInstance(ModEffects.TACTIC_OVERWHELM_EFFECT, (int)getSafeAttributeValue(attacker,AttributesRegistry.tactic_overwhelm_duration), 1, false, true, true));
            }
        }

        // Ranged
        if(rangeType == RangeType.RANGED) {
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.rage_ranged_gain_chance)) {
                attacker.addEffect(new MobEffectInstance(ModEffects.RAGE_EFFECT, (int)getSafeAttributeValue(attacker,AttributesRegistry.rage_duration), 1, false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.tactic_hitrun_ranged_gain_chance)) {
                attacker.addEffect(new MobEffectInstance(ModEffects.TACTIC_HITRUN_EFFECT, (int)getSafeAttributeValue(attacker,AttributesRegistry.tactic_hitrun_duration), 1, false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.tactic_assault_ranged_gain_chance)) {
                attacker.addEffect(new MobEffectInstance(ModEffects.TACTIC_ASSAULT_EFFECT, (int)getSafeAttributeValue(attacker,AttributesRegistry.tactic_assault_duration), 1, false, true, true));
            }
            if(attacker.getRandom().nextDouble() < getSafeAttributeValue(attacker, AttributesRegistry.tactic_overwhelm_ranged_gain_chance)) {
                attacker.addEffect(new MobEffectInstance(ModEffects.TACTIC_OVERWHELM_EFFECT, (int)getSafeAttributeValue(attacker,AttributesRegistry.tactic_overwhelm_duration), 1, false, true, true));
            }
        }
    }

    protected static void applyOnHurtInflictEffects(LivingEntity attacker, LivingEntity defender, RangeType rangeType) {

    }

    protected static void applyOnHurtGainEffects(LivingEntity attacker, LivingEntity defender, RangeType rangeType) {
        if(defender.getRandom().nextDouble() < getSafeAttributeValue(defender,AttributesRegistry.fortify_onhurt_gain_chance)) {
            defender.addEffect(new MobEffectInstance(ModEffects.FORTIFY_EFFECT, (int)getSafeAttributeValue(defender,AttributesRegistry.fortify_duration), 1, false, true, true));
        }
        if(defender.getRandom().nextDouble() < getSafeAttributeValue(defender,AttributesRegistry.rage_onhurt_gain_chance)) {
            defender.addEffect(new MobEffectInstance(ModEffects.RAGE_EFFECT, (int)getSafeAttributeValue(defender,AttributesRegistry.rage_duration), 1, false, true, true));
        }
    }



    @SubscribeEvent
    public static void onLivingShieldBlock(LivingShieldBlockEvent event) {
        if(event.getOriginalBlock()) {
            double fortifyChance = getSafeAttributeValue(event.getEntity(), AttributesRegistry.fortify_onblock_gain_chance);

            if(event.getEntity().getRandom().nextDouble() < fortifyChance) {
                // Fortify will be applied
                event.getEntity().addEffect(new MobEffectInstance(ModEffects.FORTIFY_EFFECT, (int)getSafeAttributeValue(event.getEntity(),AttributesRegistry.fortify_duration), 1, false, true, true));
            }
        }
    }

    @SubscribeEvent
    public static void onArmorHurtEvent(ArmorHurtEvent event) {
        // Add weapon and armor durability
        double armorDurability = getSafeAttributeValue(event.getEntity(), AttributesRegistry.armor_durability);
        double weaponDurability = getSafeAttributeValue(event.getEntity(), AttributesRegistry.weapon_durability);
        event.getArmorItemStack(EquipmentSlot.BODY);
        for(EquipmentSlot slot : event.getArmorMap().keySet()) {
            if(slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND) {
                event.setNewDamage(slot, (float) (event.getOriginalDamage(slot) / weaponDurability));
            } else {
                event.setNewDamage(slot, (float) (event.getOriginalDamage(slot) / armorDurability));
            }
        }


    }
}
