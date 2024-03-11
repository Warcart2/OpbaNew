package net.warcar.opba;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;

public abstract class OnHitAbility extends Ability {
	protected boolean isActive;
	protected boolean wasActive;

	public OnHitAbility(ResourceLocation name, int cooldown, int charge) {
		this(name, cooldown, charge, NO_ABILITY);
	}

	public OnHitAbility(ResourceLocation name, int cooldown, int charge, Ability origin) {
		super(name, cooldown, charge, origin);
		this.wasActive = false;
		this.isActive = false;
	}

	public void onHit(Entity source, Entity target) {
		this.isActive = false;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void setActive(boolean newActive) {
		this.isActive = newActive;
	}

	@Override
	public CompoundTag toTag() {
		CompoundTag out = super.toTag();
		out.putBoolean("active", this.isActive);
		return out;
	}

	@Override
	public void trueTick(Entity entity) {
		if (this.charge == 1) {
			this.isActive = true;
		}
		if (!this.isActive && this.wasActive){
			this.setOnCooldown();
		}
		this.charge = Math.max(this.charge - 1, 0);
		this.cooldown = Math.max(this.cooldown - 1, 0);
		this.wasActive = this.isActive;
	}
}
