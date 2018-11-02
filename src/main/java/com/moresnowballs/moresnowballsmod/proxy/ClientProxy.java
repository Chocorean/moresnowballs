package com.moresnowballs.moresnowballsmod.proxy;

import com.moresnowballs.moresnowballsmod.MoreSnowballsMod;
import com.moresnowballs.moresnowballsmod.entity.*;
import com.moresnowballs.moresnowballsmod.event.EventHandlerClient;
import com.moresnowballs.moresnowballsmod.registry.ModItems;
import com.moresnowballs.moresnowballsmod.renderer.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.*;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        MoreSnowballsMod.LOGGER.info("Registering Entity Rendering handlers");
        RenderingRegistry.registerEntityRenderingHandler(EntityFlintSnowball.class, RenderFlintSnowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFireSnowball.class, RenderFireSnowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPoisonSnowball.class, RenderPoisonSnowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTNTSnowball.class, RenderTNTSnowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherSnowball.class, RenderWitherSnowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGumSnowball.class, RenderGumSnowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCustomSnowball.class, RenderCustomSnowball::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieSnowball.class, RenderZombieSnowball::new);
    }
    @Override
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventHandlerClient());
    }
    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }
    @Override
    public void serverStarting(FMLServerStartingEvent event){ super.serverStarting(event); }
    @Override
    public void serverStopping(FMLServerStoppingEvent event){ super.serverStopping(event); }
    @Override
    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MoreSnowballsMod.MODID + ":" + id, "inventory"));
    }

}
