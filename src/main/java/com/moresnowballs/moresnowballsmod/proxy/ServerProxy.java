package com.moresnowballs.moresnowballsmod.proxy;

import com.moresnowballs.moresnowballsmod.MoreSnowballsMod;
import com.moresnowballs.moresnowballsmod.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ServerProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        EntityRegistry.registerModEntity(new ResourceLocation(MoreSnowballsMod.MODID, "moresnowballs"), EntityFlintSnowball.class, MoreSnowballsMod.MODID + ".flint_snowball", 38, MoreSnowballsMod.instance, 64, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(MoreSnowballsMod.MODID, "moresnowballs"), EntityFireSnowball.class, MoreSnowballsMod.MODID + ".fire_snowball", 39, MoreSnowballsMod.instance, 64, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(MoreSnowballsMod.MODID, "moresnowballs"), EntityPoisonSnowball.class, MoreSnowballsMod.MODID + ".poison_snowball", 40, MoreSnowballsMod.instance, 64, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(MoreSnowballsMod.MODID, "moresnowballs"), EntityTNTSnowball.class, MoreSnowballsMod.MODID + ".tnt_snowball", 41, MoreSnowballsMod.instance, 64, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(MoreSnowballsMod.MODID, "moresnowballs"), EntityWitherSnowball.class, MoreSnowballsMod.MODID + ".wither_snowball", 42, MoreSnowballsMod.instance, 64, 3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(MoreSnowballsMod.MODID, "moresnowballs"), EntityGumSnowball.class, MoreSnowballsMod.MODID + ".gum_snowball", 43, MoreSnowballsMod.instance, 64, 3, true);
    }
}
