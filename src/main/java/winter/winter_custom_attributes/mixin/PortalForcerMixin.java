package winter.winter_custom_attributes.mixin;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.PortalForcer;
import net.neoforged.neoforge.common.Tags;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import winter.winter_custom_attributes.Config;
import winter.winter_custom_attributes.WinterCustomAttributes;

import java.util.Optional;

import static winter.winter_custom_attributes.event.TagRegistry.block_portal_base;


@Mixin(PortalForcer.class)
public class PortalForcerMixin {

    @Shadow
    @Final
    protected ServerLevel level;

    @Inject(method = "createPortal", at = @At("HEAD"), cancellable = true)
    private void injected(BlockPos pos, Direction.Axis axis, CallbackInfoReturnable<Optional<BlockUtil.FoundRectangle>> cir) {
        if(Config.NETHER_PORTAL_GENERATE_TWIN.isFalse()) {
            PortalForcer portalForcer = (PortalForcer)(Object)this;
            // pos -> source coordinates, level -> target level

           int offset = -1;
           int minY = level.dimensionType().minY() + 5;
           int maxY = level.dimensionType().logicalHeight() + minY - 10;
           int y = 0;
           int baseY = maxY;
           BlockPos basePos = new BlockPos((int)(pos.getX() / level.dimensionType().coordinateScale()) , y, (int)(pos.getZ() / level.dimensionType().coordinateScale()));

            // By default we search top down, but for overworld we go bot up
           if(level.dimension() == Level.OVERWORLD) {
               offset = +1;
               baseY = minY;
           }

            y = baseY + offset;
           int tries = 0;
            do {
                while(y >= minY && y <= maxY) {
                    BlockPos pos2 = new BlockPos(basePos.getX(), y, basePos.getZ());
                    if(level.getBlockState(pos2.above(1)).is(BlockTags.AIR) && level.getBlockState(pos2.above(2)).is(BlockTags.AIR) && (level.getBlockState(pos2).is(block_portal_base))) {
                        WinterCustomAttributes.LOGGER.info("Above: " + pos2.above(1).getX() + ":" + pos2.above(1).getY() + ":" + pos2.above(1).getZ());
                        WinterCustomAttributes.LOGGER.info("Above2: " + pos2.above(2).getX() + ":" + pos2.above(2).getY() + ":" + pos2.above(2).getZ());
                        WinterCustomAttributes.LOGGER.info("Base: " + pos2.getX() + ":" + pos2.getY() + ":" + pos2.getZ());
                        cir.setReturnValue(Optional.of(new BlockUtil.FoundRectangle(pos2.immutable(), 2, 3)));
                        return;
                    }
                    y += offset;
                }
                basePos = new BlockPos(basePos.getX() + 8, y, basePos.getZ() + 8);
                y = baseY + offset;
                tries++;
            } while(tries <= 20); // we search until we find a spot and exit via return or failed 20 times
        }
    }

    @Redirect( method = "createPortal",
            at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;OBSIDIAN:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    public Block overwriteObsidianBlock() {
        return Config.getNetherPortalBlock();
    }

    /*@Redirect( method = "createPortal",
            at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;NETHER_PORTAL:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    public Block overwritePortalBlock() {
        if(Config.NETHER_PORTAL_GENERATE_TWIN.isFalse()) {
            return Blocks.AIR;
        }
        return Blocks.NETHER_PORTAL;

    }*/

}
