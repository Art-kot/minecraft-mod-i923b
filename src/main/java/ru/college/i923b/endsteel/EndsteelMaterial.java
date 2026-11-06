package ru.college.i923b.endsteel;
import net.minecraft.item.*;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.recipe.Ingredient;
public enum EndsteelMaterial implements ToolMaterial {
 STANDARD(1.0f), FAST(2.0f);
 private final float speed;
 EndsteelMaterial(float speed) { this.speed = speed; }
 public int getDurability() { return Math.round(ToolMaterials.NETHERITE.getDurability() * 1.25f); }
 public float getMiningSpeedMultiplier() { return ToolMaterials.NETHERITE.getMiningSpeedMultiplier() * speed; }
 public float getAttackDamage() { return ToolMaterials.NETHERITE.getAttackDamage(); }
 public TagKey<Block> getInverseTag() { return ToolMaterials.NETHERITE.getInverseTag(); }
 public int getEnchantability() { return ToolMaterials.NETHERITE.getEnchantability(); }
 public Ingredient getRepairIngredient() { return Ingredient.ofItems(ModItems.END_INGOT); }
}
