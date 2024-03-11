package net.warcar.opba;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.core.BlockPos;

public abstract class Ability extends ForgeRegistryEntry<Ability> {
	public static final Ability NO_ABILITY = new Ability(new ResourceLocation("opba", "no_ability"), 0, 0){
		@Override
		public void onUse(Entity ignored) {}
	};
	protected Ability origin;
	protected int maxCooldown;
	protected int cooldown;
	protected int maxCharge;
	protected int charge;

	public Ability(ResourceLocation name, int cooldown, int charge) {
		this(name, cooldown, charge, NO_ABILITY);
	}

	public Ability(ResourceLocation name, int cooldown, int charge, Ability origin){
		this.setRegistryName(name);
		this.maxCooldown = cooldown;
		this.maxCharge = charge;
		this.origin = origin;
	}

	public abstract void onUse(Entity entity);

	public boolean beforeCharge(Entity entity) {
		return this.cooldown == 0;
	}

	public void setOnCooldown() {
		this.cooldown = this.maxCooldown;
	}

	public void setOnCharge() {
		this.charge = this.maxCharge;
	}

	public Ability getOrigin() {
		return this.origin;
	}

	public boolean canEvolve(Entity entity) {
		return false;
	}

	public void setCooldown(int newCooldown) {
		this.cooldown = newCooldown;
	}

	public void setCharge(int newCharge) {
		this.charge = newCharge;
	}

	public void trueTick(Entity entity) {
		if (this.charge == 1) {
			this.onUse(entity);
			this.setOnCooldown();
		}
		this.charge = Math.max(this.charge - 1, 0);
		this.cooldown = Math.max(this.cooldown - 1, 0);
	}

	public CompoundTag toTag() {
		CompoundTag out = new CompoundTag();
		out.putString("name", this.getRegistryName().toString());
		out.putInt("charge", this.charge);
		out.putInt("cooldown", this.cooldown);
		return out;
	}

	public static Ability fromTag(CompoundTag tag) {
		ResourceLocation name = new ResourceLocation(tag.getString("name"));
		if (!ModRegistries.ABILITIES.get().containsKey(name)) {
			return NO_ABILITY;
		}
		Ability out = ModRegistries.ABILITIES.get().getValue(name);
		if (tag.contains("time")) {
			((ContiniusAbility) out).setTime(tag.getInt("time"));
		}
		if (tag.contains("pos")) {
			CompoundTag inTag = tag.getCompound("pos");
			int x = inTag.getInt("x");
			int y = inTag.getInt("y");
			int z = inTag.getInt("z");
			((PositionedAbility) out).deploy(new BlockPos(x, y, z));
		}
		if (tag.contains("active")) {
			((OnHitAbility) out).setActive(tag.getBoolean("active"));
		}
		out.cooldown = tag.getInt("cooldown");
		out.charge = tag.getInt("charge");
		return out;
	}
}
