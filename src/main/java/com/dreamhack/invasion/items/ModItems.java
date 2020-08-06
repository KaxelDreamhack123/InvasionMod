package com.dreamhack.invasion.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = "invasion", bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("invasion")
public class ModItems {

    public static final Item stormbreaker = null;
    public static final Item uru_ingot = null;

     @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS))
                .setRegistryName("uru_ingot"));
        //Tools
        event.getRegistry().register(new SwordItem(ModItemTier.URU, 7, 0.6f, new Item.Properties()
                .group(ItemGroup.COMBAT)).setRegistryName("stormbreaker"));
     }

     public enum ModItemTier implements IItemTier {
         URU(4, 1500, 1, 5.0F, 250, () -> {
             return Ingredient.fromItems(ModItems.uru_ingot);
         });

         private final int harvestLevel;
         private final int maxUses;
         private final float efficiency;
         private final float attackDamage;
         private final int enchantAbility;
         private final LazyValue<Ingredient> repairMaterial;

         private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantAbility, Supplier<Ingredient> repairMaterial){
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantAbility = enchantAbility;
            this.repairMaterial = new LazyValue<>(repairMaterial);
         }

         @Override
         public int getMaxUses() {
             return this.maxUses;
         }

         @Override
         public float getEfficiency() {
             return this.efficiency;
         }

         @Override
         public float getAttackDamage() {
             return this.attackDamage;
         }

         @Override
         public int getHarvestLevel() {
             return this.harvestLevel;
         }

         @Override
         public int getEnchantability() {
             return this.enchantAbility;
         }

         @Override
         public Ingredient getRepairMaterial() {
             return this.repairMaterial.getValue();
         }
     }

}
