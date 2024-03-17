
/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package net.warcar.opba.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OpbaModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.LIBRARIAN) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 15),

					new ItemStack(OpbaModItems.SPECIAL_BOOK.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.BOOK), new ItemStack(OpbaModItems.SPECIAL_BOOK.get()), 15, 5, 0.05f));
		}
	}
}
