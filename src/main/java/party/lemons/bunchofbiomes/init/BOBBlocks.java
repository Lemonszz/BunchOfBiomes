package party.lemons.bunchofbiomes.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import party.lemons.bunchofbiomes.BunchOfBiomes;
import party.lemons.bunchofbiomes.blocks.BlockClayDirt;
import party.lemons.bunchofbiomes.blocks.BlockMud;
import party.lemons.bunchofbiomes.item.ModeledItem;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = BunchOfBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(BunchOfBiomes.MODID)
public class BOBBlocks
{
	public static final Block MUD = Blocks.AIR;
	public static final Block CLAY_DIRT = Blocks.AIR;

	@SubscribeEvent
	public static void onRegisterItem(RegistryEvent.Register<Item> event)
	{
		blockList.stream().filter(b->(b instanceof ModeledItem) && ((ModeledItem) b).hasModel()).forEach(b->registerItemBlock(event.getRegistry(), b));
	}

	@SubscribeEvent
	public static void onRegisterBlock(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> r = event.getRegistry();

		registerBlock(r, new BlockMud(Block.Properties.create(Material.CLAY, MaterialColor.BROWN_TERRACOTTA).sound(SoundType.SLIME).hardnessAndResistance(0.25F)), "mud");
		registerBlock(r, new BlockClayDirt(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA).sound(SoundType.STONE).hardnessAndResistance(0.4F)), "clay_dirt");
	}

	public static Block registerBlock(IForgeRegistry<Block> registry, Block block, String name)
	{
		block.setRegistryName(BunchOfBiomes.MODID, name);
		registry.register(block);
		blockList.add(block);
		return block;
	}

	public static void registerItemBlock(IForgeRegistry<Item> registry, Block block)
	{
		BlockItem ib = new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS));
		ib.setRegistryName(block.getRegistryName());

		BOBItems.getItemList().add(ib);
		registry.register(ib);
	}

	public static List<Block> getBlockList()
	{
		return blockList;
	}

	private static List<Block> blockList = new ArrayList<>();
}
