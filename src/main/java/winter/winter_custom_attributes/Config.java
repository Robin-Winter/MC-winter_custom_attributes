package winter.winter_custom_attributes;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;


public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();


    public static final ModConfigSpec.BooleanValue SCORCHING_EFFECT_ENABLE = BUILDER
            .comment("Determines if the scorching effect should be applied to players in biomes with the #winter_custom_attributes:env_scorching tag. Also requires players to have Skylight > 12 in daylight.")
            .define("scorchingEffect_Enable", false);

    public static final ModConfigSpec.IntValue SCORCHING_EFFECT_AMPLIFIER = BUILDER
            .comment("Amplifier for the effects of the scorching effect.")
            .defineInRange("scorchingEffect_Amplifier", 0, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.BooleanValue FREEZING_EFFECT_ENABLE = BUILDER
            .comment("Determines if the freezing effect should be applied to players in biomes with the #winter_custom_attributes:env_freezing tag. Also requires players to have Skylight >= 15 or Skylight > Blocklight or be swimming.")
            .define("freezingEffect_Enable", false);

    public static final ModConfigSpec.IntValue FREEZING_EFFECT_AMPLIFIER = BUILDER
            .comment("Amplifier for the effects of the freezing effect.")
            .defineInRange("freezingEffect_Amplifier", 0, 0, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();
}
