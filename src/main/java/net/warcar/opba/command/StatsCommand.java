
package net.warcar.opba.command;

import org.checkerframework.checker.units.qual.s;

import net.warcar.opba.procedures.StatsSpeedSetSelfProcedure;
import net.warcar.opba.procedures.StatsSpeedSetProcedure;
import net.warcar.opba.procedures.StatsSpeedGetSelfProcedure;
import net.warcar.opba.procedures.StatsSpeedGetProcedure;
import net.warcar.opba.procedures.StatsSpeedAddSelfProcedure;
import net.warcar.opba.procedures.StatsSpeedAddProcedure;
import net.warcar.opba.procedures.StatsRegenerateSelfProcedure;
import net.warcar.opba.procedures.StatsRegenerateProcedure;
import net.warcar.opba.procedures.StatsPowerSetSelfProcedure;
import net.warcar.opba.procedures.StatsPowerSetProcedure;
import net.warcar.opba.procedures.StatsPowerGetSelfProcedure;
import net.warcar.opba.procedures.StatsPowerGetProcedure;
import net.warcar.opba.procedures.StatsPowerAddSelfProcedure;
import net.warcar.opba.procedures.StatsPowerAddProcedure;
import net.warcar.opba.procedures.StatsIntelligenceSetSelfProcedure;
import net.warcar.opba.procedures.StatsIntelligenceSetProcedure;
import net.warcar.opba.procedures.StatsIntelligenceGetSelfProcedure;
import net.warcar.opba.procedures.StatsIntelligenceGetProcedure;
import net.warcar.opba.procedures.StatsIntelligenceAddSelfProcedure;
import net.warcar.opba.procedures.StatsIntelligenceAddProcedure;
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
		event.getDispatcher().register(Commands.literal("stats").requires(s -> s.hasPermission(1))
				.then(Commands.literal("durability").then(Commands.literal("set").then(Commands.argument("amount", DoubleArgumentType.doubleArg(-100, 500)).then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
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
				}))).then(Commands.literal("get").then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
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
				})).then(Commands.literal("add").then(Commands.argument("amount", DoubleArgumentType.doubleArg(-500, 500)).then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
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
				})))).then(Commands.literal("intelligence").then(Commands.literal("set").then(Commands.argument("amount", DoubleArgumentType.doubleArg(0, 500)).then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsIntelligenceSetProcedure.execute(arguments);
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

					StatsIntelligenceSetSelfProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.literal("get").then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsIntelligenceGetProcedure.execute(arguments, entity);
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

					StatsIntelligenceGetSelfProcedure.execute(entity);
					return 0;
				})).then(Commands.literal("add").then(Commands.argument("amount", DoubleArgumentType.doubleArg(-500, 500)).then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsIntelligenceAddProcedure.execute(arguments, entity);
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

					StatsIntelligenceAddSelfProcedure.execute(arguments, entity);
					return 0;
				})))).then(Commands.literal("power").then(Commands.literal("set").then(Commands.argument("amount", DoubleArgumentType.doubleArg(0, 500)).then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsPowerSetProcedure.execute(arguments);
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

					StatsPowerSetSelfProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.literal("get").then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsPowerGetProcedure.execute(arguments, entity);
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

					StatsPowerGetSelfProcedure.execute(entity);
					return 0;
				})).then(Commands.literal("add").then(Commands.argument("amount", DoubleArgumentType.doubleArg(-500, 500)).then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsPowerAddProcedure.execute(arguments);
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

					StatsPowerAddSelfProcedure.execute(arguments, entity);
					return 0;
				})))).then(Commands.literal("speed").then(Commands.literal("set").then(Commands.argument("amount", DoubleArgumentType.doubleArg(-20, 500)).then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsSpeedSetProcedure.execute(arguments);
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

					StatsSpeedSetSelfProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.literal("get").then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsSpeedGetProcedure.execute(arguments, entity);
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

					StatsSpeedGetSelfProcedure.execute(entity);
					return 0;
				})).then(Commands.literal("add").then(Commands.argument("amount", DoubleArgumentType.doubleArg(-500, 500)).then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StatsSpeedAddProcedure.execute(arguments);
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

					StatsSpeedAddSelfProcedure.execute(arguments, entity);
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

					StatsRegenerateSelfProcedure.execute(entity);
					return 0;
				})));
	}
}
