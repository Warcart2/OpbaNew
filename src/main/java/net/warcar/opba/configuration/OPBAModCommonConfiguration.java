package net.warcar.opba.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class OPBAModCommonConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_BORN_POWER;
	static {
		BUILDER.push("Stats");
		MAX_BORN_POWER = BUILDER.comment("Max Power On Start").define("MaxBornPower", (double) 100);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
