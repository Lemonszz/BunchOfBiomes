package party.lemons.bunchofbiomes.features;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.Feature;
import party.lemons.bunchofbiomes.util.RandomUtil;

import java.util.Random;
import java.util.function.Function;

public class BlockBlobSpecialFeature extends Feature<BlockBlobConfig>
{
	private final BlockState[] blocks;

	public BlockBlobSpecialFeature(Function<Dynamic<?>, ? extends BlockBlobConfig> configFactoryIn, BlockState... blocks)
	{
		super(configFactoryIn);
		this.blocks = blocks;
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockBlobConfig config)
	{
		while(true)
		{
			label50:
			{
				if(pos.getY() > 3)
				{
					if(worldIn.isAirBlock(pos.down()))
					{
						break label50;
					}

					Block block = worldIn.getBlockState(pos.down()).getBlock();
					if(block != Blocks.GRASS_BLOCK && !Block.isDirt(block) && !Block.isRock(block))
					{
						break label50;
					}
				}

				if(pos.getY() <= 3)
				{
					return false;
				}

				int i1 = config.startRadius;

				for(int i = 0; i1 >= 0 && i < 3; ++i)
				{
					int xx = i1 + rand.nextInt(2);
					int yy = i1 + rand.nextInt(2);
					int zz = i1 + rand.nextInt(2);
					float rad = (float) (xx + yy + zz) * 0.333F + 0.5F;

					for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-xx, -yy, -zz), pos.add(xx, yy, zz)))
					{
						if(blockpos.distanceSq(pos) <= (double) (rad * rad))
						{
							BlockState place = RandomUtil.randomFromArray(rand, blocks);
							worldIn.setBlockState(blockpos, place, 4);
						}
					}

					pos = pos.add(-(i1 + 1) + rand.nextInt(2 + i1 * 2), 0 - rand.nextInt(2), -(i1 + 1) + rand.nextInt(2 + i1 * 2));
				}

				return true;
			}

			pos = pos.down();
		}
	}
}
