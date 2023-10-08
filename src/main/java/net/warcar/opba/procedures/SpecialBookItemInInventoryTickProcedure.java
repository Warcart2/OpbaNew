package net.warcar.opba.procedures;

import net.warcar.opba.configuration.OPBAModClientConfiguration;

import net.minecraft.world.item.ItemStack;
import net.minecraft.util.Mth;

import java.util.Random;

public class SpecialBookItemInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("CustomModelData") == 0 || itemstack.getOrCreateTag().getDouble("CustomModelData") > (double) OPBAModClientConfiguration.BOOK_TEXTURES.get()) {
			itemstack.getOrCreateTag().putDouble("CustomModelData", (Mth.nextInt(new Random(), 1, (int) (double) OPBAModClientConfiguration.BOOK_TEXTURES.get())));
		}
	}
}
