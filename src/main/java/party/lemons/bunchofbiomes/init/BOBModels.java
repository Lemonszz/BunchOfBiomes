package party.lemons.bunchofbiomes.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import party.lemons.bunchofbiomes.BunchOfBiomes;
import party.lemons.bunchofbiomes.item.ModeledItem;

@Mod.EventBusSubscriber(modid = BunchOfBiomes.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BOBModels
{

	@SubscribeEvent
	public static void onRegisterModel(ModelRegistryEvent event)
	{
		BOBItems.itemList.stream().filter(i->i instanceof ModeledItem).forEach(i->registerModel((Item & ModeledItem)i));
		BOBItems.itemList.stream().filter(i->i instanceof BlockItem).forEach(BOBModels::registerSimpleModel);
	}

	public static <ModelItem extends Item & ModeledItem> void registerModel(ModelItem item)
	{
		if(item == Items.AIR || !item.hasModel()) return;

		setModel(item, item.getModelLocation());
	}

	public static void registerSimpleModel(Item item)
	{
		if(item == Items.AIR) return;

		setModel(item, item.getRegistryName());
	}

	private static void setModel(Item item, ResourceLocation location)
	{
		Minecraft.getInstance().getItemRenderer().getItemModelMesher().register(item, new ModelResourceLocation(location, "inventory"));
	}
}
