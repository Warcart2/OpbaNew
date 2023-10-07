package net.warcar.opba.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class OPBAModCommonConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_BORN_POWER;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_BORN_DURABILITY;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_BORN_INTELLIGENCE;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_POWER;
	public static final ForgeConfigSpec.ConfigValue<Double> MIN_POWER;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_DURABILITY;
	public static final ForgeConfigSpec.ConfigValue<Double> MIN_DURABILITY;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_INTELLIGENCE;
	public static final ForgeConfigSpec.ConfigValue<Double> MIN_INTELLIGENCE;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_BORN_SPEED;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_SPEED;
	public static final ForgeConfigSpec.ConfigValue<Double> MIN_SPEED;
	public static final ForgeConfigSpec.ConfigValue<Double> TRAINING_DIF;
	static {
		BUILDER.push("Stats");
		MAX_BORN_POWER = BUILDER.comment("Maximum Power On Start").define("Max Born Power", (double) 100);
		MAX_BORN_DURABILITY = BUILDER.comment("Maximum Durability On Start").define("Max Born Durability", (double) 100);
		MAX_BORN_INTELLIGENCE = BUILDER.comment("Maximum Intelligence On Start").define("Max Born Intelligence", (double) 70);
		MAX_POWER = BUILDER.comment("Maximum Power").define("Max Power", (double) 500);
		MIN_POWER = BUILDER.comment("Minimum Power").define("Min Power", (double) 1);
		MAX_DURABILITY = BUILDER.comment("Maximum Durability").define("Max Durability", (double) 500);
		MIN_DURABILITY = BUILDER.comment("Minimum Durability").define("Min Durability", (double) -100);
		MAX_INTELLIGENCE = BUILDER.comment("Maximum Intelligence").define("Max Intelligence", (double) 500);
		MIN_INTELLIGENCE = BUILDER.comment("Minimum Intelligence").define("Min Intelligence", (double) 0);
		MAX_BORN_SPEED = BUILDER.comment("Maximum Speed On Start").define("Max Born Speed", (double) 50);
		MAX_SPEED = BUILDER.comment("Maximum Speed").define("Max Speed", (double) 500);
		MIN_SPEED = BUILDER.comment("Minimum Speed").define("Min Speed", (double) -20);
		TRAINING_DIF = BUILDER.comment("Difficulty of all the trainings").define("Trainings difficulty", (double) 500);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
