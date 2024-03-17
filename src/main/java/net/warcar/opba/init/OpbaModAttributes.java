/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.warcar.opba.init;

import net.warcar.opba.OpbaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OpbaModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, OpbaMod.MODID);
	public static final RegistryObject<Attribute> INTELLIGENCE = ATTRIBUTES.register("intelligence", () -> (new RangedAttribute(OpbaMod.MODID + ".attribute" + ".intelligence", 0, 0, 500)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, INTELLIGENCE.get());
		event.add(EntityType.PLAYER, INTELLIGENCE.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(INTELLIGENCE.get()).setBaseValue(oldP.getAttribute(INTELLIGENCE.get()).getBaseValue());
		}
	}
}
