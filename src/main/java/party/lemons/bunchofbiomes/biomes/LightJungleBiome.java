package party.lemons.bunchofbiomes.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.JungleBiome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import party.lemons.bunchofbiomes.features.BOBFeatures;
import party.lemons.bunchofbiomes.init.BOBSurface;
import party.lemons.bunchofbiomes.init.BOBSurfaceCfg;

public class LightJungleBiome extends Biome
{
	public LightJungleBiome()
	{
		super((new Biome.Builder())
				.surfaceBuilder(BOBSurface.MUD_GRASS_COARSE, BOBSurfaceCfg.CFG_GRASS)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.JUNGLE)
				.depth(0.1F)
				.scale(0.025F)
				.temperature(0.95F)
				.downfall(0.9F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.parent(null));

		this.addStructure(Feature.JUNGLE_TEMPLE, IFeatureConfig.NO_FEATURE_CONFIG);
		this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
		this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);

		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.func_222282_l(this);   //Sand/Clay/Gravel
		DefaultBiomeFeatures.addBamboo(this);

		addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{Feature.FANCY_TREE, Feature.JUNGLE_GROUND_BUSH, Feature.MEGA_JUNGLE_TREE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.1F, 0.5F, 0.33333334F}, Feature.JUNGLE_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(5, 0.1F, 1)));

		DefaultBiomeFeatures.func_222306_V(this);   //Flowers
		DefaultBiomeFeatures.addJungleGrass(this);
		DefaultBiomeFeatures.func_222315_Z(this);   //Mushroom
		DefaultBiomeFeatures.func_222311_aa(this);  //Reed/Pumpkins
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.func_222324_ac(this);  //Melon & vines
		DefaultBiomeFeatures.func_222297_ap(this);  //Ice?

		BOBFeatures.addBlockBlobs(this, 3, 1);

		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 40, 1, 2));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PANDA, 1, 1, 2));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.OCELOT, 2, 1, 1));
	}
}
