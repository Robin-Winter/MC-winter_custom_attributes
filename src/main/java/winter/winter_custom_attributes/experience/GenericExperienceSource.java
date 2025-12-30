package winter.winter_custom_attributes.experience;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.puffish.skillsmod.api.SkillsAPI;
import net.puffish.skillsmod.api.calculation.Calculation;
import net.puffish.skillsmod.api.calculation.operation.OperationFactory;
import net.puffish.skillsmod.api.calculation.prototype.BuiltinPrototypes;
import net.puffish.skillsmod.api.calculation.prototype.Prototype;
import net.puffish.skillsmod.api.experience.source.ExperienceSource;
import net.puffish.skillsmod.api.experience.source.ExperienceSourceConfigContext;
import net.puffish.skillsmod.api.experience.source.ExperienceSourceDisposeContext;
import net.puffish.skillsmod.api.util.Problem;
import net.puffish.skillsmod.api.util.Result;
import net.puffish.skillsmod.calculation.LegacyCalculation;
import winter.winter_custom_attributes.WinterCustomAttributes;


public class GenericExperienceSource implements ExperienceSource {
    private static final ResourceLocation ID = WinterCustomAttributes.location("generic_experience");
    private static final Prototype<Data> PROTOTYPE = Prototype.create(ID);

    static {
        PROTOTYPE.registerOperation(WinterCustomAttributes.location("player"), BuiltinPrototypes.PLAYER, OperationFactory.create(Data::player));
        PROTOTYPE.registerOperation(WinterCustomAttributes.location("experienceGained"), BuiltinPrototypes.NUMBER, OperationFactory.create(Data::experienceGained));
    }

    private final Calculation<Data> calculation;

    private GenericExperienceSource(final Calculation<Data> calculation) {
        this.calculation = calculation;
    }

    public static void register() {
        SkillsAPI.registerExperienceSource(ID, GenericExperienceSource::parse);
    }

    private static Result<GenericExperienceSource, Problem> parse(final ExperienceSourceConfigContext context) {
        return context.getData().andThen((rootElement -> LegacyCalculation.parse(rootElement, PROTOTYPE, context).mapSuccess(GenericExperienceSource::new)));
    }

    private record Data(ServerPlayer player, double experienceGained) { }

    public int getValue(final ServerPlayer player, final int experienceGained) {
        return (int) calculation.evaluate(new Data(player, experienceGained));
    }

    @Override
    public void dispose(ExperienceSourceDisposeContext context) {

    }
}
