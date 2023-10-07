package net.warcar.opba.procedures;

import net.warcar.opba.init.OpbaModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class StatsIntelligenceAddProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) (new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "player");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity())).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).setBaseValue(Math.min(500, Math.max(1, ((LivingEntity) (new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "player");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity())).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue() + DoubleArgumentType.getDouble(arguments, "amount"))));
	}
}
