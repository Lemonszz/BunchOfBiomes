package party.lemons.bunchofbiomes.features;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import party.lemons.bunchofbiomes.BunchOfBiomes;

@Mod.EventBusSubscriber(modid = BunchOfBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(BunchOfBiomes.MODID)
public class BOBFeatures
{
	public static Feature BLOB = new BlockBlobSpecialFeature(BlockBlobConfig::deserialize, Blocks.COBBLESTONE.getDefaultState(), Blocks.MOSSY_COBBLESTONE.getDefaultState(), Blocks.STONE.getDefaultState());

	@SubscribeEvent
	public static void onRegisterFeature(RegistryEvent.Register<Feature<?>> event)
	{
		if(registry == null)
			registry = event.getRegistry();

		BunchOfBiomes.LOGGER.debug("FEATURE REGISTER");


		BLOB = registerFeature(BLOB, "blob");
	}

	private static Feature registerFeature(Feature<?> feature, String name)
	{
		if(registry == null)
			throw new NullPointerException("Feature Registry not set, dumbass");


		feature.setRegistryName(BunchOfBiomes.MODID, name);
		registry.register(feature);

		return  feature;
	}

	public static void addBlockBlobs(Biome biome, int frequency, int startSize)
	{
		biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(BLOB, new BlockBlobConfig(Blocks.COBBLESTONE.getDefaultState(), startSize), Placement.FOREST_ROCK, new FrequencyConfig(frequency)));
	}

	private static IForgeRegistry<Feature<?>> registry;
}
