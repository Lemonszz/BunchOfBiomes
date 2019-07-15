package party.lemons.bunchofbiomes.util;

import java.util.Random;

public final class RandomUtil
{
	public static <T> T randomFromArray(Random random, T[] arr)
	{
		return arr[random.nextInt(arr.length)];
	}

	public static int randomRange(Random random, int min, int max)
	{
		return random.nextInt(max + 1 - min) + min;
	}
}
