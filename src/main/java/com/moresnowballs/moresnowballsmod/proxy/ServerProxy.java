package com.moresnowballs.moresnowballsmod.proxy;

import com.moresnowballs.moresnowballsmod.MoreSnowballsMod;
import com.moresnowballs.moresnowballsmod.entity.EntityFlintSnowball;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ServerProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        EntityRegistry.registerModEntity(new ResourceLocation(MoreSnowballsMod.MODID, "moresnowballs"), EntityFlintSnowball.class, MoreSnowballsMod.MODID + ".flint_snowball", 38, MoreSnowballsMod.instance, 64, 3, true);
    }
}
