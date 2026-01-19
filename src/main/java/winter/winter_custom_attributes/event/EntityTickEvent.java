package winter.winter_custom_attributes.event;

import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import winter.winter_custom_attributes.WinterCustomAttributes;
import winter.winter_custom_attributes.attributes.AttributesRegistry;
import winter.winter_custom_attributes.effect.ExpertiseEffect;
import winter.winter_custom_attributes.effect.ModEffects;

@EventBusSubscriber(modid = WinterCustomAttributes.MODID)
public class EntityTickEvent extends EventUtils {

    @SubscribeEvent
    public static void onTickEvent(net.neoforged.neoforge.event.tick.EntityTickEvent.Post event) {
        // Check once per second
        if(event.getEntity().tickCount % 20 == 0 && event.getEntity() instanceof LivingEntity livingEntity) {

            // Expertise Check
            if(isRelevantEntity(livingEntity) && hasExpertiseEnabled(livingEntity)) {
                // Check for Biome expertise
                if(livingEntity.level().canSeeSky(livingEntity.blockPosition())) {
                    // Check biome type if we can see the sky
                    for(TagKey<Biome> b : ExpertiseEffect.getViableBiomes(livingEntity)) {
                        if(livingEntity.level().getBiome(livingEntity.blockPosition()).is(b)) {
                            livingEntity.addEffect(new MobEffectInstance(ModEffects.EXPERTISE_EFFECT, (int)getSafeAttributeValue(livingEntity,AttributesRegistry.expertise_duration), 0, false, false, true));
                            break;
                        }
                    }
                } else if(livingEntity.level().dimension() == Level.OVERWORLD && livingEntity.blockPosition().getY() <= 32 && getSafeAttributeValue(livingEntity, AttributesRegistry.expertise_in_depths) == 1) {
                    // if we cant see the sky, we need to be deep and in the overworld
                    livingEntity.addEffect(new MobEffectInstance(ModEffects.EXPERTISE_EFFECT, (int)getSafeAttributeValue(livingEntity,AttributesRegistry.expertise_duration), 0, false, false, true));
                }
            }
        }
    }
}
