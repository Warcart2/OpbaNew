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
		double durTrained = 0;
		durTrained = amount;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			while (durTrained > (double) OPBAModCommonConfiguration.TRAINING_DIF.get()
					* Math.pow(2.3, Math.round((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability / 7))) {
				if ((double) OPBAModCommonConfiguration.TRAINING_DIF.get() * Math.pow(2.3, Math.round((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability / 7)) != 0) {
					durTrained = durTrained - (double) OPBAModCommonConfiguration.TRAINING_DIF.get()
							* Math.pow(2.3, Math.round((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability / 7));
				} else {
					durTrained = durTrained - 1;
				}
				{
					double _setval = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability + 1;
					entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Durability = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				double _setval = Math.min((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability + durTrained
						/ ((double) OPBAModCommonConfiguration.TRAINING_DIF.get() * Math.pow(2.3, Math.round((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability / 7))),
						500);
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Durability = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}