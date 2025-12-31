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

    public static Holder<Attribute> registerNewAttribute(String name, int defaultValue, int minValue, int maxValue) {
        WinterCustomAttributes.LOGGER.warn("Added attribute: attributes." + WinterCustomAttributes.MODID + ".{}", name);
        return ATTRIBUTES.register(name, () -> new RangedAttribute("attributes." + WinterCustomAttributes.MODID + "." + name,  defaultValue, minValue, maxValue));
    }

    @SubscribeEvent
    public static void modifyDefaultAttributes(EntityAttributeModificationEvent event) {
        WinterCustomAttributes.LOGGER.warn("Trying to add attribute to an entity");
        event.getTypes().forEach(et -> WinterCustomAttributes.LOGGER.warn("Add Attributes to: {}", et.toShortString()));
        event.getTypes().forEach(et -> ATTRIBUTES.getEntries().forEach( at -> event.add(et, at)));
    }
}
