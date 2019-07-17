package party.lemons.bunchofbiomes.surface;

import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MarshSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig>
{
	public MarshSurfaceBuilder() {
		super(SurfaceBuilderConfig::deserialize);
	}

	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		double d0 = Biome.INFO_NOISE.getValue((double)x * 0.25D, (double)z * 0.25D);
		if (d0 > 0.6D) {
			int i = x & 15;
			int j = z & 15;
			BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

			for(int k = startHeight; k >= 0; --k) {
				pos.setPos(i, k, j);
				if (!chunkIn.getBlockState(pos).isAir()) {
					if (k == 62 && chunkIn.getBlockState(pos).getBlock() != defaultFluid.getBlock()) {
						chunkIn.setBlockState(pos, defaultFluid, false);
						chunkIn.setBlockState(pos.down(), config.getUnderWaterMaterial(), false);
					}
					break;
				}
			}
		}

		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
	}
}