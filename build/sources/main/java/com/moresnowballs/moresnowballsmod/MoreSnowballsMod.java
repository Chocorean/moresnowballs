package com.moresnowballs.moresnowballsmod;

import com.moresnowballs.moresnowballsmod.creativetab.MoreSnowballsTab;
import com.moresnowballs.moresnowballsmod.entity.*;
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
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Mod(modid = MoreSnowballsMod.MODID, name = MoreSnowballsMod.NAME, version = MoreSnowballsMod.VERSION)
public class MoreSnowballsMod {
    public static final String MODID = "moresnowballs";
    public static final String NAME = "More Snowballs";
    public static final String VERSION = "1.0";
    public static final String CLIENT_PROXY = "com.moresnowballs.moresnowballsmod.proxy.ClientProxy";
    public static final String COMMON_PROXY = "com.moresnowballs.moresnowballsmod.proxy.ServerProxy";

    @SidedProxy(clientSide=MoreSnowballsMod.CLIENT_PROXY,serverSide = MoreSnowballsMod.COMMON_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static MoreSnowballsMod instance;

    public static final Logger LOGGER = Logger.getLogger(MoreSnowballsMod.MODID);

    public final static MoreSnowballsTab creativeTab = new MoreSnowballsTab();


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        LOGGER.info("Pre-initializing More Snowballs mod...");
        registerEntities();
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

    private static void registerEntities(){
        // list of entities to register
        ResourceLocation flintball = new ResourceLocation(MoreSnowballsMod.MODID, "inventory");
        ResourceLocation fireball = new ResourceLocation(MoreSnowballsMod.MODID, "inventory");
        ResourceLocation poisonball = new ResourceLocation(MoreSnowballsMod.MODID, "inventory");
        ResourceLocation tntball = new ResourceLocation(MoreSnowballsMod.MODID, "inventory");
        ResourceLocation witherball = new ResourceLocation(MoreSnowballsMod.MODID, "inventory");
        ResourceLocation gumball = new ResourceLocation(MoreSnowballsMod.MODID,"inventory");
        ResourceLocation customball = new ResourceLocation(MoreSnowballsMod.MODID,"inventory");
        ResourceLocation zombieball = new ResourceLocation(MoreSnowballsMod.MODID,"inventory");
        // registering
        /* old poor way
        EntityRegistry.registerModEntity(flintball, EntityFlintSnowball.class, "flint_snowball", 1, MoreSnowballsMod.MODID, 64, 10, true);
        EntityRegistry.registerModEntity(fireball, EntityFireSnowball.class, "fire_snowball", 2, MoreSnowballsMod.MODID, 64, 10, true);
        EntityRegistry.registerModEntity(poisonball, EntityPoisonSnowball.class, "poison_snowball", 3, MoreSnowballsMod.MODID, 64, 10, true);
        EntityRegistry.registerModEntity(tntball, EntityTNTSnowball.class, "tnt_snowball", 4, MoreSnowballsMod.MODID, 64, 10, true);
        EntityRegistry.registerModEntity(witherball, EntityWitherSnowball.class, "wither_snowball", 5, MoreSnowballsMod.MODID, 64, 10, true);
        EntityRegistry.registerModEntity(gumball, EntityGumSnowball.class, "gum_snowball", 6, MoreSnowballsMod.MODID, 64, 10, true);
        EntityRegistry.registerModEntity(customball, EntityCustomSnowball.class, "custom_snowball", 7, MoreSnowballsMod.MODID, 64, 10, true);
        EntityRegistry.registerModEntity(zombieball, EntityZombieSnowball.class, "zombie_snowball", 8, MoreSnowballsMod.MODID, 64, 10, true);
        la suite ne fonctionne pas non plus */
        ForgeRegistries.ENTITIES.register(new EntityEntry(EntityFlintSnowball.class, "flint_snowball"));
        ForgeRegistries.ENTITIES.register(new EntityEntry(EntityFireSnowball.class, "fire_snowball"));
        ForgeRegistries.ENTITIES.register(new EntityEntry(EntityPoisonSnowball.class, "poison_snowball"));
        ForgeRegistries.ENTITIES.register(new EntityEntry(EntityTNTSnowball.class, "tnt_snowball"));
        ForgeRegistries.ENTITIES.register(new EntityEntry(EntityWitherSnowball.class, "wither_snowball"));
        ForgeRegistries.ENTITIES.register(new EntityEntry(EntityGumSnowball.class, "gum_snowball"));
        ForgeRegistries.ENTITIES.register(new EntityEntry(EntityCustomSnowball.class, "custom_snowball"));
        ForgeRegistries.ENTITIES.register(new EntityEntry(EntityZombieSnowball.class, "zombie_snowball"));
    }
}
