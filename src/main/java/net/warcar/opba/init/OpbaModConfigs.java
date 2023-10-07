package net.warcar.opba.init;

import net.warcar.opba.configuration.OPBAModCommonConfiguration;
import net.warcar.opba.OpbaMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = OpbaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OpbaModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OPBAModCommonConfiguration.SPEC, "opba/common.toml");
		});
	}
}
