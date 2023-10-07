package net.warcar.opba.procedures;

import net.warcar.opba.init.OpbaModAttributes;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class StatsIntelligenceGetSelfProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("" + ((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue())), (false));
	}
}
