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
		((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).setBaseValue(Math.min(((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue()
				+ (Math.round(Math.random() * 100) / 200) / Math.pow(1.5, ((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue()), (double) OPBAModCommonConfiguration.TRAINING_DIF.get()));
		if (((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue() == 0) {
			i = 1;
		} else {
			i = ((LivingEntity) entity).getAttribute(OpbaModAttributes.INTELLIGENCE.get()).getBaseValue();
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(),
					(int) (Mth.nextInt(new Random(), (int) Math.pow(10, (double) OPBAModCommonConfiguration.TRAINING_DIF.get()), (int) Math.pow(10, (double) OPBAModCommonConfiguration.TRAINING_DIF.get() + 1)) / i));
	}
}
