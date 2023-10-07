
package net.warcar.opba.command;

import org.checkerframework.checker.units.qual.s;

import net.warcar.opba.procedures.StatsRegenerateProcedure;
import net.warcar.opba.procedures.StatsDurabilitySetSelfProcedure;
import net.warcar.opba.procedures.StatsDurabilitySetProcedure;
import net.warcar.opba.procedures.StatsDurabilityGetSelfProcedure;
import net.warcar.opba.procedures.StatsDurabilityGetProcedure;
import net.warcar.opba.procedures.StatsDurabilityAddSelfProcedure;
import net.warcar.opba.procedures.StatsDurabilityAddProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class StatsCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher()
				.register(Commands.literal("stats").requires(s -> s.hasPermission(1)).then(Commands.literal("intelligence").then(Commands.literal("set")).then(Commands.literal("get")).then(Commands.literal("add")))
						.then(Commands.literal("power").then(Commands.literal("set")).then(Commands.literal("get")).then(Commands.literal("add")))
						.then(Commands.literal("durability").then(Commands.literal("set").then(Commands.argument("amount", DoubleArgumentType.doubleArg(-100, 500)).then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							StatsDurabilitySetProcedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							StatsDurabilitySetSelfProcedure.execute(arguments, entity);
							return 0;
						}))).then(Commands.literal("get").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							StatsDurabilityGetProcedure.execute(arguments, entity);
							return 0;
						})).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							StatsDurabilityGetSelfProcedure.execute(entity);
							return 0;
						})).then(Commands.literal("add").then(Commands.argument("amount", DoubleArgumentType.doubleArg(-500, 500)).then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							StatsDurabilityAddProcedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							StatsDurabilityAddSelfProcedure.execute(arguments, entity);
							return 0;
						})))).then(Commands.literal("regenerate").then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							StatsRegenerateProcedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							StatsRegenerateProcedure.execute(arguments);
							return 0;
						})));
	}
}
