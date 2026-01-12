package winter.winter_custom_attributes.attributes;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;
import winter.winter_custom_attributes.WinterCustomAttributes;

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
    public static final Holder<Attribute> rage_duration = registerNewAttribute("rage_duration", 40, 0, 32768);
    public static final Holder<Attribute> fortify_onhurt_gain_chance = registerNewAttribute("fortify_onhurt_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> fortify_onblock_gain_chance = registerNewAttribute("fortify_onblock_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> fortify_duration = registerNewAttribute("fortify_duration", 40, 0, 32768);
    public static final Holder<Attribute> fortify_armor = registerNewAttribute("fortify_armor", 0, 0, 1024);
    public static final Holder<Attribute> fortify_toughness = registerNewAttribute("fortify_toughness", 0, 0, 1024);
    public static final Holder<Attribute> fortify_absorption = registerNewAttribute("fortify_absorption", 0, 0, 1024);
    public static final Holder<Attribute> slow_strength = registerNewAttribute("slow_strength", 1, 1, 10);
    public static final Holder<Attribute> slow_duration = registerNewAttribute("slow_duration", 40, 0, 1024);
    public static final Holder<Attribute> slow_meele_inflict_chance = registerNewAttribute("slow_meele_inflict_chance", 0, -1, 1);
    public static final Holder<Attribute> slow_ranged_inflict_chance = registerNewAttribute("slow_ranged_inflict_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_meele_gain_chance = registerNewAttribute("tactic_hitrun_meele_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_ranged_gain_chance = registerNewAttribute("tactic_hitrun_ranged_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_duration = registerNewAttribute("tactic_hitrun_duration", 40, 0, 32768);
    public static final Holder<Attribute> tactic_hitrun_meele_crit_chance = registerNewAttribute("tactic_hitrun_meele_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_meele_crit_damage = registerNewAttribute("tactic_hitrun_meele_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_hitrun_ranged_crit_chance = registerNewAttribute("tactic_hitrun_ranged_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_hitrun_ranged_crit_damage = registerNewAttribute("tactic_hitrun_ranged_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_hitrun_ranged_damage = registerNewAttribute("tactic_hitrun_ranged_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_hitrun_meele_damage = registerNewAttribute("tactic_hitrun_meele_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_hitrun_armor_shred = registerNewAttribute("tactic_hitrun_armor_shred", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_meele_gain_chance = registerNewAttribute("tactic_assault_meele_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_assault_ranged_gain_chance = registerNewAttribute("tactic_assault_ranged_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_assault_duration = registerNewAttribute("tactic_assault_duration", 40, 0, 32768);
    public static final Holder<Attribute> tactic_assault_meele_crit_chance = registerNewAttribute("tactic_assault_meele_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_assault_meele_crit_damage = registerNewAttribute("tactic_assault_meele_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_ranged_crit_chance = registerNewAttribute("tactic_assault_ranged_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_assault_ranged_crit_damage = registerNewAttribute("tactic_assault_ranged_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_ranged_damage = registerNewAttribute("tactic_assault_ranged_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_meele_damage = registerNewAttribute("tactic_assault_meele_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_assault_armor_shred = registerNewAttribute("tactic_assault_armor_shred", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_meele_gain_chance = registerNewAttribute("tactic_overwhelm_meele_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_overwhelm_ranged_gain_chance = registerNewAttribute("tactic_overwhelm_ranged_gain_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_overwhelm_duration = registerNewAttribute("tactic_overwhelm_duration", 40, 0, 32768);
    public static final Holder<Attribute> tactic_overwhelm_meele_crit_chance = registerNewAttribute("tactic_overwhelm_meele_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_overwhelm_meele_crit_damage = registerNewAttribute("tactic_overwhelm_meele_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_ranged_crit_chance = registerNewAttribute("tactic_overwhelm_ranged_crit_chance", 0, -1, 1);
    public static final Holder<Attribute> tactic_overwhelm_ranged_crit_damage = registerNewAttribute("tactic_overwhelm_ranged_crit_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_ranged_damage = registerNewAttribute("tactic_overwhelm_ranged_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_meele_damage = registerNewAttribute("tactic_overwhelm_meele_damage", 0, -10, 10);
    public static final Holder<Attribute> tactic_overwhelm_armor_shred = registerNewAttribute("tactic_overwhelm_armor_shred", 0, -10, 10);

    public static Holder<Attribute> registerNewAttribute(String name, double defaultValue, double minValue, double maxValue) {
        return ATTRIBUTES.register(name, () -> new RangedAttribute("attributes." + WinterCustomAttributes.MODID + "." + name,  defaultValue, minValue, maxValue));
    }
}
