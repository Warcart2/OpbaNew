package net.warcar.opba;

import net.minecraftforge.registries.RegistryManager;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OpbaMod.MODID)
public class ModRegistries {
	public static final IForgeRegistry<Ability> ABILITIES = RegistryManager.ACTIVE.getRegistry(Ability.class);
}
