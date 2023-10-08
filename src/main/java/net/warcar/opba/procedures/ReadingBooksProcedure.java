package net.warcar.opba.procedures;

import net.warcar.opba.init.OpbaModAttributes;
import net.warcar.opba.configuration.OPBAModCommonConfiguration;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

import java.util.Random;

public class ReadingBooksProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double i = 0;
		((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get())
				.setBaseValue(Math.min(Math.round(Math.random() * 100) / 200 + ((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue(), (double) OPBAModCommonConfiguration.TRAINING_DIF.get()));
		if (((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue() == 0) {
			i = 1;
		} else {
			i = ((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue();
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (Mth.nextInt(new Random(), (int) (double) OPBAModCommonConfiguration.TRAINING_DIF.get(), (int) ((double) OPBAModCommonConfiguration.TRAINING_DIF.get() * 10)) / i));
	}
}
