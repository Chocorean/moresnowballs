package com.moresnowballs.moresnowballsmod.registry;

import com.moresnowballs.moresnowballsmod.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import static com.moresnowballs.moresnowballsmod.MoreSnowballsMod.creativeTab;

public class ModItems {

    public static SnowballBase fire_snowball = (ItemFireSnowball)new ItemFireSnowball("fire_snowball").setCreativeTab(creativeTab);
    private static SnowballBase flint_snowball = (ItemFlintSnowball)new ItemFlintSnowball("flint_snowball").setCreativeTab(creativeTab);
    private static SnowballBase poison_snowball = (ItemPoisonSnowball)new ItemPoisonSnowball("poison_snowball").setCreativeTab(creativeTab);
    private static SnowballBase wither_snowball = (ItemWitherSnowball)new ItemWitherSnowball("wither_snowball").setCreativeTab(creativeTab);
    private static SnowballBase tnt_snowball = (ItemTNTSnowball)new ItemTNTSnowball("tnt_snowball").setCreativeTab(creativeTab);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                fire_snowball,
                flint_snowball,
                poison_snowball,
                wither_snowball,
                tnt_snowball
        );
    }

    public static void registerModels() {
        fire_snowball.registerItemModel();
        flint_snowball.registerItemModel();
        poison_snowball.registerItemModel();
        wither_snowball.registerItemModel();
        tnt_snowball.registerItemModel();
    }
}
