package net.warcar.opba;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;

public class ContiniusAbility extends Ability {
	protected int maxTime;
	protected int time;

	public ContiniusAbility(ResourceLocation name, int cooldown, int charge, int time) {
		super(name, cooldown, charge);
		this.maxTime = time;
	}

	public ContiniusAbility(ResourceLocation name, int cooldown, int charge, Ability origin, int time) {
		this(name, cooldown, charge, time);
		this.origin = origin;
	}

	public void setOnTimer() {
		this.time = this.maxTime;
	}

	public void onTick(Entity entity) {
	}

	public void onEnd(Entity entity) {
	}

	public void setTime(int NewTime) {
		this.time = NewTime;
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
