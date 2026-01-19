package winter.winter_custom_attributes.event;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import winter.winter_custom_attributes.attributes.AttributesRegistry;


public class EventUtils {
    public static double getSafeAttributeValue(LivingEntity entity, Holder<Attribute> attribute) {
        AttributeInstance inst = entity.getAttribute(attribute);
        if(inst != null) {
            return inst.getValue();
        } else {
            return 0;
        }
    }
    public static boolean hasExpertiseEnabled(LivingEntity entity) {
        AttributeMap map = entity.getAttributes();
        for(Holder<Attribute> atr : AttributesRegistry.expertiseSkills) {
            if(map.getInstance(atr) != null && map.getInstance(atr).getValue() > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRelevantEntity(Entity entity) {
        if(entity instanceof Player) {
            return true;
        } else if(entity instanceof Mob && !(entity instanceof WaterAnimal) && !(entity instanceof AmbientCreature) && !(entity instanceof Animal)) {
            return true;
        }

        return false;
    }
}
