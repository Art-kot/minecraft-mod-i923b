package ru.college.i923b.endsteel;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
public final class ModBlocks {
 public static final Block END_ORE = Registry.register(Registries.BLOCK, Endsteel.id("end_ore"),
  new Block(AbstractBlock.Settings.copy(Blocks.END_STONE).strength(5.0f, 6.0f).requiresTool()));
 public static final Item END_ORE_ITEM = Registry.register(Registries.ITEM, Endsteel.id("end_ore"),
  new BlockItem(END_ORE, new Item.Settings()));
 public static void initialize() {}
}
