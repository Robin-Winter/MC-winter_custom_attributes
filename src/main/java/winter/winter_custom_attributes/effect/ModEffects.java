package winter.winter_custom_attributes.effect;

import winter.winter_custom_attributes.WinterCustomAttributes;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, WinterCustomAttributes.MODID);

    public static final Holder<MobEffect> RAGE_EFFECT = MOB_EFFECTS.register("rage",
            () -> new RageEffect(MobEffectCategory.BENEFICIAL, 0xFF0000)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, WinterCustomAttributes.location("rage"), 0.1f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> FORTIFY_EFFECT = MOB_EFFECTS.register("fortify",
            () -> new FortifyEffect(MobEffectCategory.BENEFICIAL, 0x0000FF));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
