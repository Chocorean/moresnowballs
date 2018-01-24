package com.moresnowballs.moresnowballsmod.creativetab;

import com.moresnowballs.moresnowballsmod.MoreSnowballsMod;
import com.moresnowballs.moresnowballsmod.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;

public class MoreSnowballsTab extends CreativeTabs {
    public MoreSnowballsTab() {
        super(MoreSnowballsMod.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return ModItems.fire_snowball.getDefaultInstance();
    }
}
