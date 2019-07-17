package party.lemons.bunchofbiomes.item;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface ModeledItem
{
	default boolean hasModel()
	{
		return true;
	}

	default ResourceLocation getModelLocation()
	{
		if(this instanceof IForgeRegistryEntry)
		{
			return ((IForgeRegistryEntry)this).getRegistryName();
		}
		return null;
	}
}
