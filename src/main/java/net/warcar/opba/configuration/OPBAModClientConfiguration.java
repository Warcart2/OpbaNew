package net.warcar.opba.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class OPBAModClientConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> BOOK_TEXTURES;
	static {
		BUILDER.push("Textures");
		BOOK_TEXTURES = BUILDER.comment("Textures of Special book(For resource pack compatability)").define("Book Textures", (double) 3);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
