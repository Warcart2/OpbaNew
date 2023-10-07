package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;
import net.warcar.opba.configuration.OPBAModCommonConfiguration;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class StatsPowerAddSelfProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = Math.min((double) OPBAModCommonConfiguration.MAX_POWER.get(), Math.max((double) OPBAModCommonConfiguration.MIN_POWER.get(),
					(entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power + DoubleArgumentType.getDouble(arguments, "amount")));
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Power = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
