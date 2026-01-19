package winter.winter_custom_attributes.attributes;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;
import winter.winter_custom_attributes.WinterCustomAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttributesRegistry {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, WinterCustomAttributes.MODID);
    public static final Holder<Attribute> meele_crit_chance = registerNewAttribute("meele_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> meele_crit_damage = registerNewAttribute("meele_crit_damage", 1, -10, 10);
    public static final Holder<Attribute> ranged_crit_chance = registerNewAttribute("ranged_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> ranged_crit_damage = registerNewAttribute("ranged_crit_damage", 1, -10, 10);
    public static final Holder<Attribute> armor_durability = registerNewAttribute("armor_durability", 1, 0, 10);
    public static final Holder<Attribute> weapon_durability = registerNewAttribute("weapon_durability", 1, 0, 10);
    public static final Holder<Attribute> rage_meele_gain_chance = registerNewAttribute("rage_meele_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> rage_ranged_gain_chance = registerNewAttribute("rage_ranged_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> rage_onhurt_gain_chance = registerNewAttribute("rage_onhurt_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> rage_duration = registerNewAttribute("rage_duration", 60, 0, 32768);
    public static final Holder<Attribute> fortify_onhurt_gain_chance = registerNewAttribute("fortify_onhurt_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> fortify_onblock_gain_chance = registerNewAttribute("fortify_onblock_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> fortify_duration = registerNewAttribute("fortify_duration", 60, 0, 32768);
    public static final Holder<Attribute> fortify_armor = registerNewAttribute("fortify_armor", 0, 0, 1024);
    public static final Holder<Attribute> fortify_toughness = registerNewAttribute("fortify_toughness", 0, 0, 1024);
    public static final Holder<Attribute> fortify_absorption = registerNewAttribute("fortify_absorption", 0, 0, 1024);
    public static final Holder<Attribute> poison_strength = registerNewAttribute("poison_strength", 0, 0, 10);
    public static final Holder<Attribute> poison_duration = registerNewAttribute("poison_duration", 60, 0, 1024);
    public static final Holder<Attribute> poison_meele_inflict_chance = registerNewAttribute("poison_meele_inflict_chance", 0, -1, 1);
    public static final Holder<Attribute> poison_ranged_inflict_chance = registerNewAttribute("poison_ranged_inflict_chance", 0, -1, 1);
    public static final Holder<Attribute> burn_meele_inflict_chance = registerNewAttribute("burn_meele_inflict_chance", 0, -1, 1);
    public static final Holder<Attribute> burn_ranged_inflict_chance = registerNewAttribute("burn_ranged_inflict_chance", 0, -1, 1);
    public static final Holder<Attribute> slow_strength = registerNewAttribute("slow_strength", 0, 0, 10);
    public static final Holder<Attribute> slow_duration = registerNewAttribute("slow_duration", 60, 0, 1024);
    public static final Holder<Attribute> slow_meele_inflict_chance = registerNewAttribute("slow_meele_inflict_chance", 0, -1, 1);
    public static final Holder<Attribute> slow_ranged_inflict_chance = registerNewAttribute("slow_ranged_inflict_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_meele_gain_chance = registerNewAttribute("tactic_hitrun_meele_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_ranged_gain_chance = registerNewAttribute("tactic_hitrun_ranged_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_duration = registerNewAttribute("tactic_hitrun_duration", 120, 0, 32768);
    public static final Holder<Attribute> tactic_hitrun_meele_crit_chance = registerNewAttribute("tactic_hitrun_meele_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_meele_crit_damage = registerNewAttribute("tactic_hitrun_meele_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_hitrun_ranged_crit_chance = registerNewAttribute("tactic_hitrun_ranged_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_ranged_crit_damage = registerNewAttribute("tactic_hitrun_ranged_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_hitrun_ranged_damage = registerNewAttribute("tactic_hitrun_ranged_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_hitrun_meele_damage = registerNewAttribute("tactic_hitrun_meele_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_hitrun_armor_shred = registerNewAttribute("tactic_hitrun_armor_shred", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_meele_gain_chance = registerNewAttribute("tactic_assault_meele_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_assault_ranged_gain_chance = registerNewAttribute("tactic_assault_ranged_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_assault_duration = registerNewAttribute("tactic_assault_duration", 120, 0, 32768);
    public static final Holder<Attribute> tactic_assault_meele_crit_chance = registerNewAttribute("tactic_assault_meele_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_assault_meele_crit_damage = registerNewAttribute("tactic_assault_meele_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_ranged_crit_chance = registerNewAttribute("tactic_assault_ranged_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_assault_ranged_crit_damage = registerNewAttribute("tactic_assault_ranged_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_ranged_damage = registerNewAttribute("tactic_assault_ranged_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_meele_damage = registerNewAttribute("tactic_assault_meele_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_armor_shred = registerNewAttribute("tactic_assault_armor_shred", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_meele_gain_chance = registerNewAttribute("tactic_overwhelm_meele_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_overwhelm_ranged_gain_chance = registerNewAttribute("tactic_overwhelm_ranged_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_overwhelm_duration = registerNewAttribute("tactic_overwhelm_duration", 120, 0, 32768);
    public static final Holder<Attribute> tactic_overwhelm_meele_crit_chance = registerNewAttribute("tactic_overwhelm_meele_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_overwhelm_meele_crit_damage = registerNewAttribute("tactic_overwhelm_meele_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_ranged_crit_chance = registerNewAttribute("tactic_overwhelm_ranged_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_overwhelm_ranged_crit_damage = registerNewAttribute("tactic_overwhelm_ranged_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_ranged_damage = registerNewAttribute("tactic_overwhelm_ranged_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_meele_damage = registerNewAttribute("tactic_overwhelm_meele_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_armor_shred = registerNewAttribute("tactic_overwhelm_armor_shred", 0, -10, 10);
    public static final Holder<Attribute> expertise_duration = registerNewAttribute("expertise_duration", 160, 0, 32768);
    public static final Holder<Attribute> expertise_in_taiga = registerNewAttribute("expertise_in_taiga", 0, 0, 1);
    public static final Holder<Attribute> expertise_in_jungle = registerNewAttribute("expertise_in_jungle", 0, 0, 1);
    public static final Holder<Attribute> expertise_in_badlands = registerNewAttribute("expertise_in_badlands", 0, 0, 1);
    public static final Holder<Attribute> expertise_in_desert = registerNewAttribute("expertise_in_desert", 0, 0, 1);
    public static final Holder<Attribute> expertise_in_forest = registerNewAttribute("expertise_in_forest", 0, 0, 1);
    public static final Holder<Attribute> expertise_in_depths = registerNewAttribute("expertise_in_depths", 0, 0, 1);
    public static final Holder<Attribute> expertise_in_coast = registerNewAttribute("expertise_in_coast", 0, 0, 1);
    public static final Holder<Attribute> expertise_in_mountain = registerNewAttribute("expertise_in_mountain", 0, 0, 1);
    public static final Holder<Attribute> expertise_movement_mult = registerNewAttribute("expertise_movement_mult", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_oxygen = registerNewAttribute("expertise_oxygen", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_falldamage_mult = registerNewAttribute("expertise_falldamage_mult", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_fortune = registerNewAttribute("expertise_fortune", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_slow_chance = registerNewAttribute("expertise_slow_chance", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_burn_chance = registerNewAttribute("expertise_burn_chance", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_poison_chance = registerNewAttribute("expertise_poison_chance", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_stamina = registerNewAttribute("expertise_stamina", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_absorption = registerNewAttribute("expertise_absorption", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_toughness = registerNewAttribute("expertise_toughness", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_armor = registerNewAttribute("expertise_armor", 2, -1024, 1024);
    public static final Holder<Attribute> expertise_natural_regeneration = registerNewAttribute("expertise_natural_regeneration", 0, -1024, 1024);
    public static final Holder<Attribute> expertise_stealth = registerNewAttribute("expertise_stealth", 0, -1024, 1024);

    public static final List<Holder<Attribute>> expertiseSkills = new ArrayList<>(Arrays.asList(expertise_in_jungle, expertise_in_badlands, expertise_in_coast, expertise_in_desert, expertise_in_depths, expertise_in_forest, expertise_in_mountain, expertise_in_taiga));

    public static Holder<Attribute> registerNewAttribute(String name, double defaultValue, double minValue, double maxValue) {
        return ATTRIBUTES.register(name, () -> new RangedAttribute("attributes." + WinterCustomAttributes.MODID + "." + name,  defaultValue, minValue, maxValue));
    }
}
