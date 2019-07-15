package party.lemons.bunchofbiomes.surface;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import party.lemons.bunchofbiomes.init.BOBSurface;
import party.lemons.bunchofbiomes.init.BOBSurfaceCfg;

import java.util.Random;

public class SurfaceBuilderLightJungle extends SurfaceBuilder<SurfaceBuilderConfig>
{

	public SurfaceBuilderLightJungle()
	{
		super(SurfaceBuilderConfig::deserialize);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config)
	{
		if (noise > 1.0D)
		{
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BOBSurfaceCfg.CFG_DIRT);
		}
		else if (noise > -0.125D)
		{
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BOBSurfaceCfg.CFG_MUD);
		}
		else
		{
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BOBSurfaceCfg.CFG_GRASS);
		}
	}
}
