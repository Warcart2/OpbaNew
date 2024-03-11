
package net.warcar.opba.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

import net.minecraft.commands.arguments.blocks.BlockStateArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class AbilitiesCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("abilities").requires(s -> s.hasPermission(1)).then(Commands.literal("add").then(Commands.argument("name", BlockStateArgument.block()).then(Commands.argument("name", EntityArgument.player()))))
				.then(Commands.literal("remove").then(Commands.argument("name", BlockStateArgument.block()).then(Commands.argument("name", EntityArgument.player())))));
	}
}
