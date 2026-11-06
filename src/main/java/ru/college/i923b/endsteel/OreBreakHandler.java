package ru.college.i923b.endsteel;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.registry.RegistryKey;
public final class OreBreakHandler {
 private record Attempt(RegistryKey<World> world, BlockPos pos, boolean eligible) {}
 private static final Map<UUID, Attempt> ATTEMPTS = new HashMap<>();
 public static void initialize() {
  // BEFORE keeps the tool identity even when its last durability point is consumed.
  PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
   ATTEMPTS.remove(player.getUuid());
   if (state.isOf(ModBlocks.END_ORE)) {
    boolean eligible = !player.isCreative() && !player.isSpectator()
      && player.getMainHandStack().isOf(Items.NETHERITE_PICKAXE);
    ATTEMPTS.put(player.getUuid(), new Attempt(world.getRegistryKey(), pos.toImmutable(), eligible));
   }
   return true;
  });
  PlayerBlockBreakEvents.CANCELED.register((world, player, pos, state, blockEntity) -> ATTEMPTS.remove(player.getUuid()));
  PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
   Attempt attempt = ATTEMPTS.remove(player.getUuid());
   if (attempt == null || !attempt.eligible() || !state.isOf(ModBlocks.END_ORE)
       || !attempt.world().equals(world.getRegistryKey()) || !attempt.pos().equals(pos)
       || !world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS)) return;
   Block.dropStack(world, pos, new ItemStack(ModItems.END_SHARD, 1));
  });
  ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> ATTEMPTS.remove(handler.player.getUuid()));
 }
}
