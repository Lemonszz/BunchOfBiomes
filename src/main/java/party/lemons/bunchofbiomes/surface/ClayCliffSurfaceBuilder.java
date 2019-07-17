package party.lemons.bunchofbiomes.surface;

import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import party.lemons.bunchofbiomes.init.BOBSurfaceCfg;

public class ClayCliffSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig>
{
	public ClayCliffSurfaceBuilder() {
		super(SurfaceBuilderConfig::deserialize);
	}

	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		SurfaceBuilderConfig cfg =  BOBSurfaceCfg.CFG_GRASS_CLAY_DIRT_GRAVEL;

		if (noise > 1.0D) {

			cfg = BOBSurfaceCfg.CFG_CLAY_DIRT_CLAY_DIRT_GRAVEL;
		}

		this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, cfg.getTop(), cfg.getUnder(), cfg.getUnderWaterMaterial(), seaLevel);

	}

	protected void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle, BlockState bottom, int sealevel) {
		BlockState topState = top;
		BlockState middleState = middle;
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		int i = -1;
		int j = (int)(noise / 3.0D + 13.0D + random.nextDouble() * 0.25D);
		int k = x & 15;
		int l = z & 15;

		for(int i1 = startHeight; i1 >= 0; --i1) {
			pos.setPos(k, i1, l);
			BlockState blockstate2 = chunkIn.getBlockState(pos);
			if (blockstate2.isAir()) {
				i = -1;
			} else if (blockstate2.getBlock() == defaultBlock.getBlock()) {
				if (i == -1) {
					if (j <= 0) {
						topState = Blocks.AIR.getDefaultState();
						middleState = defaultBlock;
					} else if (i1 >= sealevel - 4 && i1 <= sealevel + 1) {
						topState = top;
						middleState = middle;
					}

					if (i1 < sealevel && (topState == null || topState.isAir())) {
						if (biomeIn.getTemperature(pos.setPos(x, i1, z)) < 0.15F) {
							topState = Blocks.ICE.getDefaultState();
						} else {
							topState = defaultFluid;
						}

						pos.setPos(k, i1, l);
					}

					i = j;
					if (i1 >= sealevel - 1) {
						chunkIn.setBlockState(pos, topState, false);
					} else if (i1 < sealevel - 7 - j) {
						topState = Blocks.AIR.getDefaultState();
						middleState = defaultBlock;
						chunkIn.setBlockState(pos, bottom, false);
					} else {
						chunkIn.setBlockState(pos, middleState, false);
					}
				} else if (i > 0) {
					--i;
					chunkIn.setBlockState(pos, middleState, false);
					if (i == 0 && middleState.getBlock() == Blocks.SAND && j > 1) {
						i = random.nextInt(1) + Math.max(0, i1 - 63);
						middleState = middleState.getBlock() == Blocks.RED_SAND ? Blocks.RED_SANDSTONE.getDefaultState() : Blocks.SANDSTONE.getDefaultState();
					}
				}
			}
		}

	}
}