package ru.college.i923b.endsteel;
import net.minecraft.item.*;
import net.minecraft.registry.*;
public final class ModItems {
 private static Item register(String id, Item item) { return Registry.register(Registries.ITEM, Endsteel.id(id), item); }
 public static final Item END_SHARD = register("end_shard", new Item(new Item.Settings()));
 public static final Item END_INGOT = register("end_ingot", new Item(new Item.Settings()));
 // Total damage = player base 1 + material bonus 4 + weapon bonus.
 public static final Item END_SWORD = register("end_sword", new SwordItem(EndsteelMaterial.STANDARD,
  new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(EndsteelMaterial.STANDARD, 7, -2.4f))));
 public static final Item END_AXE = register("end_axe", new AxeItem(EndsteelMaterial.FAST,
  new Item.Settings().fireproof().attributeModifiers(AxeItem.createAttributeModifiers(EndsteelMaterial.FAST, 10.0f, -3.0f))));
 public static final Item END_PICKAXE = register("end_pickaxe", new PickaxeItem(EndsteelMaterial.FAST,
  new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(EndsteelMaterial.FAST, 1.0f, -2.8f))));
 public static void initialize() {}
}
