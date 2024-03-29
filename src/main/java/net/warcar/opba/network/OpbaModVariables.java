package net.warcar.opba.network;

import org.checkerframework.checker.units.qual.Speed;

import net.warcar.opba.OpbaMod;
import net.warcar.opba.Ability;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OpbaModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		OpbaMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Born = original.Born;
			clone.Power = original.Power;
			clone.Durability = original.Durability;
			clone.Speed = original.Speed;
			clone.PowerMultiplier = original.PowerMultiplier;
			clone.DurabilityMultiplier = original.DurabilityMultiplier;
			clone.SpeedMultiplier = original.SpeedMultiplier;
			clone.AbilityCounter = original.AbilityCounter;
			clone.AllAbilities = original.AllAbilities;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("opba", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean Born = false;
		public double Power = 0;
		public double Durability = 0;
		public double Speed = 0;
		public double PowerMultiplier = 1.0;
		public double DurabilityMultiplier = 1.0;
		public double SpeedMultiplier = 1.0;
		public CompoundTag AbilityCounter = new CompoundTag();
		public List<Ability> AllAbilities = new ArrayList<>();;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				OpbaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("Born", Born);
			nbt.putDouble("Power", Power);
			nbt.putDouble("Durability", Durability);
			nbt.putDouble("Speed", Speed);
			nbt.putDouble("PowerMultiplier", PowerMultiplier);
			nbt.putDouble("DurabilityMultiplier", DurabilityMultiplier);
			nbt.putDouble("SpeedMultiplier", SpeedMultiplier);
			nbt.put("AbilityCounter", AbilityCounter);
			{
				CompoundTag subNbt = new CompoundTag();
				for (int i = 0; i < AllAbilities.size(); i++) {
					subNbt.put(String.valueOf(i), AllAbilities.get(i).toTag());
				}
				nbt.put("AllAbilities", subNbt);
			}
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Born = nbt.getBoolean("Born");
			Power = nbt.getDouble("Power");
			Durability = nbt.getDouble("Durability");
			Speed = nbt.getDouble("Speed");
			PowerMultiplier = nbt.getDouble("PowerMultiplier");
			DurabilityMultiplier = nbt.getDouble("DurabilityMultiplier");
			SpeedMultiplier = nbt.getDouble("SpeedMultiplier");
			AbilityCounter = nbt.getCompound("AbilityCounter");
			{
				CompoundTag subNbt = nbt.getCompound("AllAbilities");
				AllAbilities = new ArrayList<>();;
				for (int i = 0; i < AllAbilities.size(); i++) {
					AllAbilities.add(Ability.fromTag(subNbt.getCompound(String.valueOf(i))));
				}
			}
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Born = message.data.Born;
					variables.Power = message.data.Power;
					variables.Durability = message.data.Durability;
					variables.Speed = message.data.Speed;
					variables.PowerMultiplier = message.data.PowerMultiplier;
					variables.DurabilityMultiplier = message.data.DurabilityMultiplier;
					variables.SpeedMultiplier = message.data.SpeedMultiplier;
					variables.AbilityCounter = message.data.AbilityCounter;
					variables.AllAbilities = message.data.AllAbilities;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
