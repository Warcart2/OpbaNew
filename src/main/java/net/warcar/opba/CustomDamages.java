package net.warcar.opba;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;

public class CustomDamages extends DamageSource{
	public boolean blocked = false;
	public CustomDamages(final String type, final boolean blocked){
		super(type);
		this.blocked = blocked;
	}
	public CustomDamages(final DamageSource ref, final boolean blocked){
		super(ref.msgId);
		this.blocked = blocked;
	}
	public CustomDamages(final String type){
		super(type);
	}
	public CustomDamages(final DamageSource ref){
		super(ref.msgId);
	}
}
