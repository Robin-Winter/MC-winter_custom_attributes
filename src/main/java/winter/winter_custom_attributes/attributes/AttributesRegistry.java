package winter.winter_custom_attributes.attributes;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import winter.winter_custom_attributes.WinterCustomAttributes;

public class AttributesRegistry {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, WinterCustomAttributes.MODID);
    public static final Holder<Attribute> rage_onhit_gain_chance = registerNewAttribute("rage_onhit_gain_chance", 0, -100, 100);
    public static final Holder<Attribute> fortify_onhurt_gain_chance = registerNewAttribute("fortify_onhurt_gain_chance", 0, -100, 100);
    public static final Holder<Attribute> fortify_duration = registerNewAttribute("fortify_duration", 2, -1024, 1024);
    public static final Holder<Attribute> fortify_strength = registerNewAttribute("fortify_strength", 1, -1024, 1024);

    public static Holder<Attribute> registerNewAttribute(String name, int defaultValue, int minValue, int maxValue) {
        WinterCustomAttributes.LOGGER.warn("Added attribute: attributes." + WinterCustomAttributes.MODID + ".{}", name);
        return ATTRIBUTES.register(name, () -> new RangedAttribute("attributes." + WinterCustomAttributes.MODID + "." + name,  defaultValue, minValue, maxValue));
    }
}
