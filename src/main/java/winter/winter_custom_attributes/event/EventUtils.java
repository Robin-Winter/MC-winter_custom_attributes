package winter.winter_custom_attributes.event;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.level.LightLayer;
import winter.winter_custom_attributes.attributes.AttributesRegistry;


public class EventUtils {

    public static double getSafeAttributeValue(LivingEntity entity, Holder<Attribute> attribute) {
        return getSafeAttributeValue(entity, attribute, 0);
    }
    public static double getSafeAttributeValue(LivingEntity entity, Holder<Attribute> attribute, double nullValue) {
        AttributeInstance inst = entity.getAttribute(attribute);
        if(inst != null) {
            return inst.getValue();
        } else {
            return nullValue;
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

    public static boolean isPlayerEntity(Entity entity) {
        if(entity instanceof Player) {
            return true;
        }

        return false;
    }

    public static double getBrightnessLevel(Entity entity) {
        double dayLight = 2 * entity.level().getBrightness(LightLayer.SKY, entity.blockPosition()); //entity.level().getDayTime();
        /*if(dayLight >= 2000 && dayLight <= 10000) {
            dayLight = 1d;
        } else if(dayLight >= 14000 && dayLight <= 22000) {
            dayLight = 0.2d;
        } else if(dayLight > 22000) {
            dayLight = 0.2d + ((dayLight - 22000) / 5000);
        } else if(dayLight < 2000) {
            dayLight = 0.6d + (dayLight / 5000);
        } else if(dayLight > 10000 && dayLight < 14000) {
            dayLight = 1d - ((dayLight - 10000) / 5000);
        }

        dayLight *= entity.level().getBrightness(LightLayer.SKY, entity.blockPosition());*/
        return Math.max(dayLight, entity.level().getBrightness(LightLayer.BLOCK, entity.blockPosition()));
    }
}
