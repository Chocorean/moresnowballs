package com.moresnowballs.moresnowballsmod.item;

import com.moresnowballs.moresnowballsmod.MoreSnowballsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSnowball;

public class SnowballBase extends ItemSnowball {
    protected String name;

    public SnowballBase(String name){
        super();
        this.name=name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.maxStackSize = 64;
    }

    public void registerItemModel() {
        MoreSnowballsMod.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public SnowballBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
