package party.lemons.bunchofbiomes.init;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import party.lemons.bunchofbiomes.BunchOfBiomes;
import party.lemons.bunchofbiomes.biomes.*;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = BunchOfBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(BunchOfBiomes.MODID)
public class BOBBiomes
{
	public static final Biome LIGHT_JUNGLE = Biomes.JUNGLE;
	public static final Biome DARK_SWAMP = Biomes.DARK_FOREST;
	public static final Biome TUNDRA = Biomes.MOUNTAINS;

	@SubscribeEvent
	public static void onRegisterBiomes(RegistryEvent.Register<Biome> event)
	{
		if(biomeRegistry == null)
			biomeRegistry = event.getRegistry();

		BunchOfBiomes.LOGGER.debug("BIOME REGISTER");


		registerBiome(new LightJungleBiome(), "Light Jungle", 10, true, BiomeManager.BiomeType.WARM,Type.JUNGLE);
		registerBiome(new DarkSwampBiome(), "Dark Swamp", 10, true, BiomeManager.BiomeType.COOL,Type.SPOOKY, Type.SWAMP, Type.FOREST, Type.DENSE);
		registerBiome(new MarshBiome(), "Marsh", 10, true, BiomeManager.BiomeType.COOL,Type.PLAINS, Type.SWAMP, Type.LUSH, Type.SPARSE);
		registerBiome(new TundraBiome(), "Tundra", 10, true, BiomeManager.BiomeType.COOL,Type.MOUNTAIN, Type.PLAINS, Type.MOUNTAIN, Type.COLD, Type.SPARSE);
		registerBiome(new LightForestBiome(), "Light Forest", 10, true, BiomeManager.BiomeType.WARM,Type.FOREST, Type.PLAINS);
		registerBiome(new LightTaigaBiome(), "Light Taiga", 10, true, BiomeManager.BiomeType.COOL,Type.FOREST, Type.CONIFEROUS);
		registerBiome(new LushSwampBiome(), "Lush Swamp", 10, true, BiomeManager.BiomeType.COOL, Type.SWAMP, Type.LUSH);
		registerBiome(new ClayMountainBiome(), "Clay Cliffs", 10, true, BiomeManager.BiomeType.WARM, Type.MOUNTAIN, Type.HILLS);
	}

	public static BiomeMeta registerBiome(Biome biome, String name, int weight, boolean allowPlayerSpawning, BiomeManager.BiomeType spawnType, Type... types)
	{
		if(biomeRegistry == null)
			throw new NullPointerException("Biome Registry not set, dumbass");

		biome.setRegistryName(BunchOfBiomes.MODID, name.toLowerCase().replaceAll(" ", "_"));
		biomeRegistry.register(biome);

		BiomeMeta meta = new BiomeMeta(biome, weight, allowPlayerSpawning, types);
		biomes.add(meta);

		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(spawnType, new BiomeManager.BiomeEntry(biome, weight));

		return meta;
	}

	private static final List<BiomeMeta> biomes = new ArrayList<>();
	private static IForgeRegistry<Biome> biomeRegistry;

	private static class BiomeMeta
	{
		private final Biome biome;
		private final int biomeWeight;
		private final Type[] types;
		private final boolean allowPlayerSpawning;

		public BiomeMeta(Biome biome, int spawnWeight, boolean allowPlayerSpawning, Type... types)
		{
			this.biome = biome;
			this.biomeWeight = spawnWeight;
			this.allowPlayerSpawning = allowPlayerSpawning;
			this.types = types;
		}

		public Biome getBiome()
		{
			return biome;
		}

		public int getBiomeWeight()
		{
			return biomeWeight;
		}

		public boolean allowPlayerSpawning()
		{
			return allowPlayerSpawning;
		}

		public Type[] getTypes()
		{
			return types;
		}
	}

}
