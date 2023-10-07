package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AttributesApplyProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
				.setBaseValue(((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability / 10));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
				.setBaseValue(((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability / 20 + 20));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
				.setBaseValue(((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power / 5));
	}
}
