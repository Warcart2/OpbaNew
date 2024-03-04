package net.warcar.opba;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class Ability extends ForgeRegistryEntry<Ability> {
	public static final Ability NO_ABIILTY = new Ability(new ResourceLocation("opba", "no_ability"), 0, 0);
	protected ResourceLocation name;
	protected Ability origin;
	protected int maxCooldown;
	protected int cooldown;
	protected int maxCharge;
	protected int charge;

	public Ability(ResourceLocation name, int cooldown, int charge) {
		this(name, cooldown, charge, NO_ABIILTY);
	}

	public Ability(ResourceLocation name, int cooldown, int charge, Ability origin){
		this.name = name;
		this.maxCooldown = cooldown;
		this.maxCharge = charge;
		this.origin = origin;
	}

	public void onUse(Entity entity) {
	}

	public boolean beforeCharge(Entity entity) {
		return false;
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

	public ResourceLocation getName() {
		return this.name;
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
		out.putString("name", this.name.toString());
		out.putInt("charge", this.charge);
		out.putInt("cooldown", this.cooldown);
		return out;
	}

	public static Ability fromTag(CompoundTag tag) {
		ResourceLocation name = new ResourceLocation(tag.getString("name"));
		if (!ModRegistries.ABILITIES.containsKey(name)) {
			return NO_ABIILTY;
		}
		Ability out = ModRegistries.ABILITIES.getValue(name);
		if (tag.contains("time")) {
			((ContiniusAbility) out).setTime(tag.getInt("time"));
		}
		out.cooldown = tag.getInt("cooldown");
		out.charge = tag.getInt("charge");
		return out;
	}
}
