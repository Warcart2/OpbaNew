package net.warcar.opba;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModAbilities {
	public ModAbilities() {
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Ability> event) {
		event.getRegistry().registerAll(Ability.NO_ABILITY);
	}
}
