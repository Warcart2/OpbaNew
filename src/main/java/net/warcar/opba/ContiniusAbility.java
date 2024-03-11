package net.warcar.opba;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public abstract class ContiniusAbility extends Ability {
	protected int maxTime;
	protected int time;

	public ContiniusAbility(ResourceLocation name, int cooldown, int charge, int time) {
		this(name, cooldown, charge, time, NO_ABILITY);
	}

	public ContiniusAbility(ResourceLocation name, int cooldown, int charge, int time, Ability origin) {
		super(name, cooldown, charge, origin);
		this.maxTime = time;
	}

	public void setOnTimer() {
		this.time = this.maxTime;
	}

	public abstract void onTick(Entity entity);

	public abstract void onEnd(Entity entity);

	public void setTime(int newTime) {
		this.time = newTime;
	}

	@Override
	public void trueTick(Entity entity) {
		if (this.charge == 1) {
			this.onUse(entity);
			this.setOnTimer();
		}
		if (this.time > 1) {
			this.onTick(entity);
		} else if(this.time == 1) {
			this.onEnd(entity);
			this.setOnCooldown();
		}
		this.charge = Math.max(this.charge - 1, 0);
		this.cooldown = Math.max(this.cooldown - 1, 0);
		this.time = Math.max(this.time - 1, 0);
	}

	@Override
	public CompoundTag toTag() {
		CompoundTag out = super.toTag();
		out.putInt("time", this.time);
		return out;
	}
}
