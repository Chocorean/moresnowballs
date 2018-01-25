package com.moresnowballs.moresnowballsmod;

import com.moresnowballs.moresnowballsmod.creativetab.MoreSnowballsTab;
import com.moresnowballs.moresnowballsmod.entity.EntityFireSnowball;
import com.moresnowballs.moresnowballsmod.proxy.CommonProxy;
import com.moresnowballs.moresnowballsmod.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.logging.Logger;

@Mod(modid = MoreSnowballsMod.MODID, name = MoreSnowballsMod.NAME, version = MoreSnowballsMod.VERSION)
public class MoreSnowballsMod {
    public static final String MODID = "moresnowballs";
    public static final String NAME = "More Snowballs";
    public static final String VERSION = "1.0";
    public static final String CLIENT_PROXY = "com.moresnowballs.moresnowballsmod.proxy.ClientProxy";
    public static final String COMMON_PROXY = "com.moresnowballs.moresnowballsmod.proxy.CommonProxy";

    @SidedProxy(clientSide=MoreSnowballsMod.CLIENT_PROXY,serverSide = MoreSnowballsMod.COMMON_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static MoreSnowballsMod instance;

    public static final Logger LOGGER = Logger.getLogger(MoreSnowballsMod.MODID);

    public final static MoreSnowballsTab creativeTab = new MoreSnowballsTab();


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        LOGGER.info("Pre-initializing More Snowballs mod...");
        int modEntityID=0;
        proxy.preInit(event);
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Initializing More Snowballs mod...");
        proxy.init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Post-initializing More Snowballs mod...");
        proxy.postInit(event);
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
        }
    }
}
