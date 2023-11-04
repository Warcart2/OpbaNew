package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JumpBoostProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntityLiving());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() || entity.isSprinting()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power / 1000 + entity.getDeltaMovement().y()),
					(entity.getDeltaMovement().z())));
		} else {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), ((entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power / 2500 + entity.getDeltaMovement().y()),
					(entity.getDeltaMovement().z())));
		}
	}
}
