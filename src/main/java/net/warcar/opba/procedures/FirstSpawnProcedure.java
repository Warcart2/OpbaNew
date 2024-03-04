package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;
import net.warcar.opba.init.OpbaModAttributes;
import net.warcar.opba.configuration.OPBAModCommonConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class FirstSpawnProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Born) {
			{
				boolean _setval = true;
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Born = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).setBaseValue(
					((int) (new Random().nextGaussian() * ((double) OPBAModCommonConfiguration.MAX_BORN_INTELLIGENCE.get() - (double) OPBAModCommonConfiguration.MIN_INTELLIGENCE.get()) + (double) OPBAModCommonConfiguration.MIN_INTELLIGENCE.get())));
			{
				double _setval = (int) (new Random().nextGaussian() * ((double) OPBAModCommonConfiguration.MAX_BORN_POWER.get() - (double) OPBAModCommonConfiguration.MIN_POWER.get()) + (double) OPBAModCommonConfiguration.MIN_POWER.get());
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Power = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (int) (new Random().nextGaussian() * ((double) OPBAModCommonConfiguration.MAX_BORN_DURABILITY.get() - (double) OPBAModCommonConfiguration.MIN_DURABILITY.get())
						+ (double) OPBAModCommonConfiguration.MIN_DURABILITY.get());
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Durability = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (int) (new Random().nextGaussian() * ((double) OPBAModCommonConfiguration.MAX_BORN_SPEED.get() - (double) OPBAModCommonConfiguration.MIN_SPEED.get()) + (double) OPBAModCommonConfiguration.MIN_SPEED.get());
				entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
