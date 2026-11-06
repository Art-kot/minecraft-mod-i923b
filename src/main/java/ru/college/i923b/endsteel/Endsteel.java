package ru.college.i923b.endsteel;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public final class Endsteel implements ModInitializer {
 public static final String MOD_ID = "endsteel";
 public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
 public static Identifier id(String name) { return Identifier.of(MOD_ID, name); }
 @Override public void onInitialize() {
  ModBlocks.initialize(); ModItems.initialize(); OreBreakHandler.initialize();
  ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(e -> e.add(ModBlocks.END_ORE));
  ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(e -> {e.add(ModItems.END_SHARD);e.add(ModItems.END_INGOT);});
  ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(e -> {e.add(ModItems.END_PICKAXE);e.add(ModItems.END_AXE);});
  ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(e -> e.add(ModItems.END_SWORD));
  BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS),
    GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("end_ore_surface")));
  LOGGER.info("Проект загружен успешно");
 }
}
