package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;
import net.warcar.opba.configuration.OPBAModCommonConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TrainingDurabilityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			{
				double _setval = Math.min((double) OPBAModCommonConfiguration.MAX_DURABILITY.get(), (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability
						+ amount / Math.pow(Math.round((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability), (double) OPBAModCommonConfiguration.TRAINING_DIF.get()));
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
