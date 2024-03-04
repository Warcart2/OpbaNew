package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;
import net.warcar.opba.init.OpbaModAttributes;
import net.warcar.opba.configuration.OPBAModCommonConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TrainingSpeed2Procedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.isSprinting()) {
			{
				double _setval = Math.min((double) OPBAModCommonConfiguration.MAX_SPEED.get(),
						(entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Speed + (0.25 * (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().z())))
								/ Math.pow(Math.round((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Speed), (double) OPBAModCommonConfiguration.TRAINING_DIF.get()));
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = Math.min((double) OPBAModCommonConfiguration.MAX_POWER.get(),
						(entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power + (0.125 * (Math.abs(entity.getDeltaMovement().x()) + Math.abs(entity.getDeltaMovement().z())))
								/ Math.pow(Math.round((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power), (double) OPBAModCommonConfiguration.TRAINING_DIF.get()));
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Power = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (50000 * (double) OPBAModCommonConfiguration.TRAINING_DIF.get()
				- ((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue() * 100 <= (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power
				&& !(entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Born) {
			{
				boolean _setval = true;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Born = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
