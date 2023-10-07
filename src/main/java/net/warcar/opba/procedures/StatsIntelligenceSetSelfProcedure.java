package net.warcar.opba.procedures;

import net.warcar.opba.init.OpbaModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class StatsIntelligenceSetSelfProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).setBaseValue((DoubleArgumentType.getDouble(arguments, "amount")));
	}
}
