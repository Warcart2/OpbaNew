package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;
import net.warcar.opba.configuration.OPBAModCommonConfiguration;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class StatsSpeedAddSelfProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = Math.min((double) OPBAModCommonConfiguration.MAX_SPEED.get(), Math.max((double) OPBAModCommonConfiguration.MIN_SPEED.get(),
					(entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Power + DoubleArgumentType.getDouble(arguments, "amount")));
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Speed = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
