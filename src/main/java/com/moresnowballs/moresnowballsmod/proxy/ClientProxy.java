package com.moresnowballs.moresnowballsmod.proxy;

import com.moresnowballs.moresnowballsmod.MoreSnowballsMod;
import com.moresnowballs.moresnowballsmod.entity.EntityFireSnowball;
import com.moresnowballs.moresnowballsmod.entity.EntityFlintSnowball;
import com.moresnowballs.moresnowballsmod.registry.ModItems;
import com.moresnowballs.moresnowballsmod.renderer.RenderFlintSnowball;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.*;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        RenderingRegistry.registerEntityRenderingHandler(EntityFlintSnowball.class, (RenderManager renderManagerIn) -> new RenderFlintSnowball(renderManagerIn));
    }
    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
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
