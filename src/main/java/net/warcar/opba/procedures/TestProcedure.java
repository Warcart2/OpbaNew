package net.warcar.opba.procedures;

import net.warcar.opba.OpbaMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class TestProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.OFFHAND) {
			if (itemstack.getItem() instanceof SwordItem && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, itemstack) != 0) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("1b7c4994-b96c-4bbb-b54f-9b9562ef9146"), OpbaMod.MODID + "." + "2-sworded style", 1.2, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			} else if (itemstack.getItem() instanceof SwordItem) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("1b7c4994-b96c-4bbb-b54f-9b9562ef9146"), OpbaMod.MODID + "." + "2-sworded style", 1.1, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
			if (itemstack.getItem() instanceof SwordItem && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, itemstack) != 0) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("15211dd1-8d6d-4418-8dca-768b3b6240e4"), OpbaMod.MODID + "." + "3-sworded style", 1.4, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			} else if (itemstack.getItem() instanceof SwordItem) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("15211dd1-8d6d-4418-8dca-768b3b6240e4"), OpbaMod.MODID + "." + "2-sworded style", 1.2, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		}
	}
}
