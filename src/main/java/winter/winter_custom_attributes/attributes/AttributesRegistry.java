package winter.winter_custom_attributes.attributes;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import winter.winter_custom_attributes.WinterCustomAttributes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class AttributesRegistry {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, WinterCustomAttributes.MODID);
    public static final Holder<Attribute> onHitGainRageChance = registerNewAttribute("onHitGainRageChance", 0, -100, 100);

    public static Holder<Attribute> registerNewAttribute(String name, int defaultValue, int minValue, int maxValue) {
        return ATTRIBUTES.register(name, () -> new RangedAttribute("attributes." + WinterCustomAttributes.MODID + "." + name,  defaultValue, minValue, maxValue));
    }

    @SubscribeEvent
    public static void modifyDefaultAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(et -> ATTRIBUTES.getEntries().forEach(
                at -> event.add(et, at)));
    }

    public static List<Field> getEntityTypes() {

        return Arrays.stream(EntityType.class.getDeclaredFields()).filter(f ->
                Modifier.isStatic(f.getModifiers()) && f.getType() == EntityType.class).collect(toList());
    }
}
