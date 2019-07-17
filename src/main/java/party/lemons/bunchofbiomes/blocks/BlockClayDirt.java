package party.lemons.bunchofbiomes.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import party.lemons.bunchofbiomes.item.ModeledItem;

public class BlockClayDirt extends Block implements ModeledItem
{

	public BlockClayDirt(Properties properties)
	{
		super(properties);
	}
}
