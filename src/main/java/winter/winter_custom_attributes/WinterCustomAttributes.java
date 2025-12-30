package winter.winter_custom_attributes;

import net.minecraft.resources.ResourceLocation;
import winter.winter_custom_attributes.attributes.AttributesRegistry;
import winter.winter_custom_attributes.effect.ModEffects;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import winter.winter_custom_attributes.experience.GenericExperienceSource;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(WinterCustomAttributes.MODID)
public class WinterCustomAttributes {
    public static final String MODID = "winter_custom_attributes";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WinterCustomAttributes(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);


        AttributesRegistry.ATTRIBUTES.register(modEventBus);
        ModEffects.register(modEventBus);
        GenericExperienceSource.register();

        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static ResourceLocation location(final String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
