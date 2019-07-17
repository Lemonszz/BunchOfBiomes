package party.lemons.bunchofbiomes.init;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class BOBSurfaceCfg
{
	public static final SurfaceBuilderConfig CFG_GRASS = SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG;
	public static final SurfaceBuilderConfig CFG_DIRT = SurfaceBuilder.CORASE_DIRT_DIRT_GRAVEL_CONFIG;
	public static final SurfaceBuilderConfig CFG_MUD = new SurfaceBuilderConfig(BOBBlocks.MUD.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());
	public static final SurfaceBuilderConfig CFG_GRASS_DIRT_MUD = new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), BOBBlocks.MUD.getDefaultState());
	public static final SurfaceBuilderConfig CFG_GRASS_CLAY_DIRT_GRAVEL = new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), BOBBlocks.CLAY_DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState());
	public static final SurfaceBuilderConfig CFG_CLAY_DIRT_CLAY_DIRT_GRAVEL = new SurfaceBuilderConfig(BOBBlocks.CLAY_DIRT.getDefaultState(), BOBBlocks.CLAY_DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState());
}
