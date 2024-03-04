package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AttributesApplyProcedure {
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
		double durab = 0;
		double speed = 0;
		double power = 0;
		durab = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability
				* (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).DurabilityMultiplier;
		speed = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Speed
				* (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).SpeedMultiplier;
		power = (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power
				* (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).PowerMultiplier;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue((durab / 10));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue((durab / 5 + 20));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).setBaseValue((power / 5));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).setBaseValue((speed / 10 + 3.5 + power / 1000));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).setBaseValue((durab / 10));
		if (entity.isSprinting()) {
			((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue((1 + speed / 200 + power / 1000));
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue((power / 1000 + 0.1 + speed / 1000));
		} else {
			((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(1);
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
		}
	}
}
