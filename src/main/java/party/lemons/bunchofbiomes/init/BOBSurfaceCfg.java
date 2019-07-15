package party.lemons.bunchofbiomes.init;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class BOBSurfaceCfg
{
	public static final SurfaceBuilderConfig CFG_GRASS = SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG;
	public static final SurfaceBuilderConfig CFG_DIRT = SurfaceBuilder.CORASE_DIRT_DIRT_GRAVEL_CONFIG;
	public static final SurfaceBuilderConfig CFG_MUD = new SurfaceBuilderConfig(Blocks.SOUL_SAND.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());
}
