package net.warcar.opba;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;

public abstract class PositionedAbility extends ContiniusAbility {
	protected BlockPos pos;

	public PositionedAbility(ResourceLocation name, int cooldown, int charge, int time) {
		this(name, cooldown, charge, time, new BlockPos(0, 0, 0), NO_ABILITY);
	}

	public PositionedAbility(ResourceLocation name, int cooldown, int charge, int time, Ability origin) {
		this(name, cooldown, charge, time, new BlockPos(0, 0, 0), origin);
	}

	public PositionedAbility(ResourceLocation name, int cooldown, int charge, int time, BlockPos inPos) {
		this(name, cooldown, charge, time, inPos, NO_ABILITY);
	}

	public PositionedAbility(ResourceLocation name, int cooldown, int charge, int time, BlockPos inPos, Ability origin) {
		super(name, cooldown, charge, time, origin);
		this.pos = inPos;
	}

	public BlockPos getDeploymentPos() {
		return new BlockPos(pos.getX(), pos.getY(), pos.getZ());
	}

	public void deploy(BlockPos inPos) {
		pos = inPos;
	}

	public abstract void positonedPart(Level world);

	@Override
	public CompoundTag toTag() {
		CompoundTag out = super.toTag();
		CompoundTag in = new CompoundTag();
		in.putInt("x", pos.getX());
		in.putInt("y", pos.getY());
		in.putInt("z", pos.getZ());
		out.put("pos", in);
		return out;
	}
}
