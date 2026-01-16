package winter.winter_custom_attributes.event;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;

public class EventUtils {
    public static double getSafeAttributeValue(LivingEntity entity, Holder<Attribute> attribute) {
        AttributeInstance inst = entity.getAttribute(attribute);
        if(inst != null) {
            return inst.getValue();
        } else {
            return 0;
        }
    }
}
