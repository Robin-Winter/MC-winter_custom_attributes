package winter.winter_custom_attributes.event;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;

public class TagRegistry {
    public static final TagKey<Block> block_portal_base = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes", "portal_base_blocks"));
    public static final TagKey<Biome> biome_env_scorching = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes", "env_scorching"));
    public static final TagKey<Biome> biome_env_freezing = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("winter_custom_attributes", "env_freezing"));
}
