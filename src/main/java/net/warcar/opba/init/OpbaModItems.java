
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.warcar.opba.init;

import net.warcar.opba.item.SpecialBookItem;
import net.warcar.opba.OpbaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

public class OpbaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, OpbaMod.MODID);
	public static final RegistryObject<Item> SPECIAL_BOOK = REGISTRY.register("special_book", () -> new SpecialBookItem());
}
