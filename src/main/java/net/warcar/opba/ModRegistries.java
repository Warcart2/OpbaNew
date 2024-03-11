package net.warcar.opba;

import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistries {
	public static Supplier<IForgeRegistry<Ability>> ABILITIES;

	@SubscribeEvent
	public static void reg(NewRegistryEvent event) {
		ABILITIES = event.create(new RegistryBuilder().setName(new ResourceLocation("opba", "abilities")).setType(Ability.class).setMaxID(2147483646));
	}
}
