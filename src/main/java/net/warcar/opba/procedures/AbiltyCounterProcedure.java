package net.warcar.opba.procedures;

import net.minecraft.world.entity.Entity;

public class AbiltyCounterProcedure {
	public static double execute(Entity entity, boolean write, double value, String ability) {
		if (entity == null || ability == null)
			return 0;
		if (write) {
			entity.getPersistentData().putDouble(("opba_abilty_counter_of_" + ability), (value));
		} else {
			return entity.getPersistentData().getDouble(("opba_abilty_counter_of_" + ability));
		}
		return 0;
	}
}
