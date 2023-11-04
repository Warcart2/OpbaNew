package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FallSaveProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getDistance());
		}
	}

	public static void execute(Entity entity, double distance) {
		execute(null, entity, distance);
	}

	private static void execute(@Nullable Event event, Entity entity, double distance) {
		if (entity == null)
			return;
		if (distance <= (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
