package party.lemons.bunchofbiomes.init;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.BadlandsSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import party.lemons.bunchofbiomes.BunchOfBiomes;
import party.lemons.bunchofbiomes.surface.ClayCliffSurfaceBuilder;
import party.lemons.bunchofbiomes.surface.MarshSurfaceBuilder;
import party.lemons.bunchofbiomes.surface.SurfaceBuilderLightJungle;

@Mod.EventBusSubscriber(modid = BunchOfBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(BunchOfBiomes.MODID)
public class BOBSurface
{
	public static final SurfaceBuilder<SurfaceBuilderConfig> MUD_GRASS_COARSE = new SurfaceBuilderLightJungle();
	public static final SurfaceBuilder<SurfaceBuilderConfig> MARSH = new MarshSurfaceBuilder();
	public static final SurfaceBuilder<SurfaceBuilderConfig> CLAY_CLIFF = new ClayCliffSurfaceBuilder();

	@SubscribeEvent
	public static void onRegisterBiomes(RegistryEvent.Register<SurfaceBuilder<?>> event)
	{
		if(registry == null)
			registry = event.getRegistry();

		BunchOfBiomes.LOGGER.debug("SURFACE REGISTER");

		registerSurfaceBuilder(MUD_GRASS_COARSE, "mud_grass_coarse");
		registerSurfaceBuilder(MARSH, "marsh");
		registerSurfaceBuilder(CLAY_CLIFF, "clay_cliff");
	}

	public static SurfaceBuilder<?> registerSurfaceBuilder(SurfaceBuilder<?> surface, String name)
	{
		if(registry == null)
			throw  new NullPointerException("Didnt set surface registry");

		surface.setRegistryName(BunchOfBiomes.MODID, name);

		registry.register(surface);
		return surface;
	}

	private static IForgeRegistry<SurfaceBuilder<?>> registry;
}
