package winter.winter_custom_attributes.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.portal.PortalForcer;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import winter.winter_custom_attributes.Config;

@Mixin(PortalForcer.class)
public class PortalForcerMixin {
    @Redirect( method = "createPortal",
            at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;OBSIDIAN:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    public Block overwriteBlock() {
        return Config.getNetherPortalBlock();

    }

}
