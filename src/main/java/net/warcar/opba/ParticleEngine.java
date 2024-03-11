package net.warcar.opba;

import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleOptions;

import com.mojang.math.Vector3d;

public class ParticleEngine {
	public static void line(LevelAccessor world, Vector3d pos1, Vector3d pos2, ParticleOptions particle) {
		double x1 = pos1.x;
		double y1 = pos1.y;
		double z1 = pos1.z;
		double x2 = pos2.x;
		double y2 = pos2.y;
		double z2 = pos2.z;
		double inLine = 0;
		double i = 0;
		inLine = 20;
		while (inLine > i) {
			world.addParticle(particle, (((inLine - (i + 1)) * x1 + i * x2) / (inLine - 1)), (((inLine - (i + 1)) * y1 + i * y2) / (inLine - 1)), (((inLine - (i + 1)) * z1 + i * z2) / (inLine - 1)), 0, 0, 0);
			i = i + 1;
		}
	}

	public static void ring(LevelAccessor world, Vector3d pos, double resolution, double shift, Vec2 size, Axis axis, ParticleOptions particle) {
		double size1 = size.x;
		double size2 = size.y;
		double loop = 0;
		while (loop < resolution) {
			if (axis.equals(Axis.Y)) {
				world.addParticle(particle, (pos.x + Math.cos(((Math.PI * 2) / resolution) * loop + shift) * (size1 / 2)), pos.y, (pos.z + Math.sin(((Math.PI * 2) / resolution) * loop + shift) * (size2 / 2)), 0, 0, 0);
			} else if (axis.equals(Axis.Z)) {
				world.addParticle(particle, (pos.x + Math.cos(((Math.PI * 2) / resolution) * loop + shift) * (size1 / 2)), (pos.y + Math.sin(((Math.PI * 2) / resolution) * loop + shift) * (size2 / 2)), pos.z, 0, 0, 0);
			} else {
				world.addParticle(particle, pos.x, (pos.y + Math.cos(((Math.PI * 2) / resolution) * loop + shift) * (size1 / 2)), (pos.z + Math.sin(((Math.PI * 2) / resolution) * loop + shift) * (size2 / 2)), 0, 0, 0);
			}
			loop = loop + 1;
		}
	}

	public static void ring(LevelAccessor world, Vector3d pos, double resolution, double shift, float size, Axis axis, ParticleOptions particle) {
		ring(world, pos, resolution, shift, new Vec2(size, size), axis, particle);
	}

	public static void sphere(LevelAccessor world, Vector3d pos, double rings, Vector3d size, ParticleOptions particle) {
		double loop = 0;
		double num = 0;
		while (loop < rings) {
			num = (Math.PI / rings) * loop;
			ring(world, new Vector3d(pos.x, pos.y + (num - 1) * size.z / 3, pos.z), rings, 0, new Vec2((float) (size.x * Math.sin(num)), (float) (size.y * Math.sin(num))), Axis.Y, particle);
			loop = loop + 1;
		}
	}

	public static void sphere(LevelAccessor world, Vector3d pos, double rings, double size, ParticleOptions particle) {
		sphere(world, pos, rings, new Vector3d(size, size, size), particle);
	}

	public static void spiral(LevelAccessor world, Vector3d pos, double resolution, double rings, double shift, Vec2 size, double times, Axis axis, ParticleOptions particle) {
		double loop = 0;
		double inLoop = 0;
		while (loop < times) {
			inLoop = 0;
			while (inLoop < resolution) {
				ring(world, pos, times, inLoop * rings * 2 + shift, new Vec2((float) (size.x * (1 - inLoop / resolution)), (float) (size.y * (1 - inLoop / resolution))), axis, particle);
				inLoop = inLoop + 1;
			}
			loop = loop + 1;
		}
	}

	public static void spiral(LevelAccessor world, Vector3d pos, double resolution, double rings, double shift, float size, double times, Axis axis, ParticleOptions particle) {
		spiral(world, pos, resolution, rings, shift, new Vec2(size, size), times, axis, particle);
	}

	public static void twoSpreresWithIntersection(LevelAccessor world, Vector3d pos, double distance, double rings, double shift, double size1, double size2, Axis axis, ParticleOptions particle1, ParticleOptions particle2,
			ParticleOptions particle3) {
		Vector3d pos1 = new Vector3d(0, 0, 0);
		Vector3d pos2 = new Vector3d(0, 0, 0);
		if (axis.equals(Axis.X)) {
			pos1.x = pos.x;
			pos1.y = pos.y + Math.cos(shift) * distance / 2;
			pos1.z = pos.z + Math.sin(shift) * distance / 2;
			pos2.x = pos.x;
			pos2.y = pos.y + Math.cos(Math.PI + shift) * distance / 2;
			pos2.z = pos.z + Math.sin(Math.PI + shift) * distance / 2;
		} else if (axis.equals(Axis.Y)) {
			pos1.x = pos.x + Math.cos(shift) * distance / 2;
			pos1.y = pos.y;
			pos1.z = pos.z + Math.sin(shift) * distance / 2;
			pos2.x = pos.x + Math.cos(Math.PI + shift) * distance / 2;
			pos2.y = pos.y;
			pos2.z = pos.z + Math.sin(Math.PI + shift) * distance / 2;
		} else {
			pos1.x = pos.x + Math.cos(shift) * distance / 2;
			pos1.y = pos.y + Math.sin(shift) * distance / 2;
			pos1.z = pos.z;
			pos2.x = pos.x + Math.cos(Math.PI + shift) * distance / 2;
			pos2.y = pos.y + Math.sin(Math.PI + shift) * distance / 2;
			pos2.z = pos.z;
		}
		double loop = 0;
		while (loop < rings) {
			double num = (Math.PI / rings) * loop;
			double loopIn = 0;
			while (loopIn < rings) {
				double innerX = pos1.x + Math.cos((Math.PI * 2) / rings * loopIn) * size1 / 2 * Math.sin(num);
				double innerY = pos1.y + (num - 1) * size1 / 3;
				double innerZ = pos1.z + Math.sin(((Math.PI * 2) / rings) * loopIn) * size1 / 2 * Math.sin(num);
				double dist = Math.sqrt(Math.pow(innerX - pos2.x, 2) + Math.pow(innerY - pos2.y, 2) + Math.pow(innerZ - pos2.z, 2)) - 0.2;
				world.addParticle(dist < size2 / 3 ? particle3 : particle1, innerX, innerY, innerZ, 0, 0, 0);
				loopIn = loopIn + 1;
			}
			loop = loop + 1;
		}
		loop = 0;
		while (loop < rings) {
			double num = (Math.PI / rings) * loop;
			double loopIn = 0;
			while (loopIn < rings) {
				double innerX = pos2.x + Math.cos((Math.PI * 2) / rings * loopIn) * size2 / 2 * Math.sin(num);
				double innerY = pos2.y + (num - 1) * size2 / 3;
				double innerZ = pos2.z + Math.sin((Math.PI * 2) / rings * loopIn) * size2 / 2 * Math.sin(num);
				double dist = Math.sqrt(Math.pow(innerX - pos1.x, 2) + Math.pow(innerY - pos1.y, 2) + Math.pow(innerZ - pos1.z, 2)) - 0.2;
				world.addParticle(dist < size1 / 3 ? particle3 : particle2, innerX, innerY, innerZ, 0, 0, 0);
				loopIn = loopIn + 1;
			}
			loop = loop + 1;
		}
	}

	public enum Axis {
		X, Y, Z;
	}
}
