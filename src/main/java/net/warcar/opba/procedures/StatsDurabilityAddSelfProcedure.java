package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class StatsDurabilityAddSelfProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = Math.min(500, Math.max(1, (entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).Durability + DoubleArgumentType.getDouble(arguments, "amount")));
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Durability = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
