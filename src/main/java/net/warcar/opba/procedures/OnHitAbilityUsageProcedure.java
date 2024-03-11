package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;
import net.warcar.opba.OnHitAbility;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnHitAbilityUsageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			((sourceentity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).AllAbilities).forEach(abilityiterator -> {
				if ((/*Ability*/abilityiterator instanceof OnHitAbility) && ((OnHitAbility) /*Ability*/abilityiterator).isActive()) {
					if ((/*Ability*/abilityiterator instanceof OnHitAbility)) {
						((OnHitAbility) /*Ability*/abilityiterator).onHit(sourceentity, entity);
					}
				}
			});
		}
	}
}
