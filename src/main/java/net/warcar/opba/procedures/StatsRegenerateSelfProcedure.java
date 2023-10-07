package net.warcar.opba.procedures;

import net.warcar.opba.network.OpbaModVariables;

import net.minecraft.world.entity.Entity;

public class StatsRegenerateSelfProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Born = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		FirstSpawnProcedure.execute(entity);
	}
}
