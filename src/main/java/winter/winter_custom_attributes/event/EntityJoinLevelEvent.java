package winter.winter_custom_attributes.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import winter.winter_custom_attributes.WinterCustomAttributes;

// EntityJoinLevelEvent
@EventBusSubscriber(modid = WinterCustomAttributes.MODID)
public class EntityJoinLevelEvent {

    @SubscribeEvent
    public static void onEntityJoinLevelEvent(net.neoforged.neoforge.event.entity.EntityJoinLevelEvent event) {
        
    }
}
