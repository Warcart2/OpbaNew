package net.warcar.opba.procedures;

import net.warcar.opba.ParticleEngine;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

import javax.annotation.Nullable;

import com.mojang.math.Vector3d;

@Mod.EventBusSubscriber
public class TestProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double tick = 0;
		if (false) {
			world.addParticle(ParticleTypes.DRAGON_BREATH, x, y, z, 0, 1, 0);
		}
		tick = entity.getPersistentData().getDouble("tick");
		ParticleEngine.twoSpreresWithIntersection(world, new Vector3d(x, y + 1, z), 4 - tick, 25, 0, 3, 3, ParticleEngine.Axis.Y, ParticleTypes.FLAME, ParticleTypes.SOUL_FIRE_FLAME, ParticleTypes.DRAGON_BREATH);
		entity.getPersistentData().putDouble("tick", ((entity.getPersistentData().getDouble("tick") + 0.1) % 4));
	}
}
