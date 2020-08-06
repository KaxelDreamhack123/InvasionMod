package com.dreamhack.invasion.items;

import com.dreamhack.invasion.utils.helpers.KeyBoardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class StormbreakerItem extends Item {
    public StormbreakerItem(Properties properties) {
        super(properties);
    }


    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyBoardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Only the most worthy can lift this hammer..."));
        }else{
            tooltip.add(new StringTextComponent("Press Shift for more information"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


}
