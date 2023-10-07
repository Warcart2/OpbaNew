package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class StatsDurabilitySetSelfProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = DoubleArgumentType.getDouble(arguments, "amount");
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Durability = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
