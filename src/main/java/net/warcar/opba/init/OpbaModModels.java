
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.warcar.opba.init;

import net.warcar.opba.client.model.Modelmarine;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class OpbaModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelmarine.LAYER_LOCATION, Modelmarine::createBodyLayer);
	}
}
