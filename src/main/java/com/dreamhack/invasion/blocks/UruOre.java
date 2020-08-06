package com.dreamhack.invasion.blocks;

import com.dreamhack.invasion.utils.helpers.KeyBoardHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.List;


public class UruOre extends Block {


    public UruOre() {
        super(Block.Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(5.0f)
                .harvestLevel(2)
        );
        setRegistryName("uru_ore");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyBoardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Spawn only in Plains. You can only dig with a netherite pickaxe. Super rare."));
        }else{
            tooltip.add(new StringTextComponent("Press Shift for more information"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


}
