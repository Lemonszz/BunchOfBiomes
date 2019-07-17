package party.lemons.bunchofbiomes.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import party.lemons.bunchofbiomes.BunchOfBiomes;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = BunchOfBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(BunchOfBiomes.MODID)
public class BOBItems
{
	@SubscribeEvent
	public static void onRegisterItem(RegistryEvent.Register<Item> event)
	{

	}

	public static Item registerItem(IForgeRegistry<Item> registry, Item item, String name)
	{
		item.setRegistryName(BunchOfBiomes.MODID, name);
		itemList.add(item);

		registry.register(item);

		return item;
	}


	public static List<Item> itemList = new ArrayList<>();
	public static List<Item> getItemList()
	{
		return itemList;
	}
}
