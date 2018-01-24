package com.moresnowballs.moresnowballsmod.registry;

import com.moresnowballs.moresnowballsmod.item.ItemFireSnowball;
import com.moresnowballs.moresnowballsmod.item.ItemFlintSnowball;
import com.moresnowballs.moresnowballsmod.item.ItemPoisonSnowball;
import com.moresnowballs.moresnowballsmod.item.SnowballBase;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import static com.moresnowballs.moresnowballsmod.MoreSnowballsMod.creativeTab;

public class ModItems {

    public static SnowballBase fire_snowball = (SnowballBase)new ItemFireSnowball("fire_snowball").setCreativeTab(creativeTab);
    private static SnowballBase flint_snowball = (SnowballBase)new ItemFlintSnowball("flint_snowball").setCreativeTab(creativeTab);
    private static SnowballBase poison_snowball = (SnowballBase)new ItemPoisonSnowball("poison_snowball").setCreativeTab(creativeTab);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                fire_snowball,
                flint_snowball,
                poison_snowball
        );
    }

    public static void registerModels() {
        fire_snowball.registerItemModel();
        flint_snowball.registerItemModel();
        poison_snowball.registerItemModel();
    }
}
