package com.moresnowballs.moresnowballsmod;

import com.moresnowballs.moresnowballsmod.creativetab.MoreSnowballsTab;
import com.moresnowballs.moresnowballsmod.entity.*;
import com.moresnowballs.moresnowballsmod.proxy.CommonProxy;
import com.moresnowballs.moresnowballsmod.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.Logger;

@Mod(modid = MoreSnowballsMod.MODID, name = MoreSnowballsMod.NAME, version = MoreSnowballsMod.VERSION)
public class MoreSnowballsMod {
    public static final String MODID = "moresnowballs";
    static final String NAME = "More Snowballs";
    static final String VERSION = "1.0";
    private static final String CLIENT_PROXY = "com.moresnowballs.moresnowballsmod.proxy.ClientProxy";
    private static final String SERVER_PROXY = "com.moresnowballs.moresnowballsmod.proxy.ServerProxy";

    private static int entityId = 0;

    @SidedProxy(clientSide = MoreSnowballsMod.CLIENT_PROXY, serverSide = MoreSnowballsMod.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static MoreSnowballsMod instance;

    public static final Logger LOGGER = FMLLog.log;

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
        LOGGER.info("Registering Entities");
        // res locations for entities to register
        ResourceLocation flintballRL  = new ResourceLocation(MoreSnowballsMod.MODID, "flint_snowball");
        ResourceLocation fireballRL   = new ResourceLocation(MoreSnowballsMod.MODID, "fire_snowball");
        ResourceLocation poisonballRL = new ResourceLocation(MoreSnowballsMod.MODID, "poison_snowball");
        ResourceLocation tntballRL    = new ResourceLocation(MoreSnowballsMod.MODID, "tnt_snowball");
        ResourceLocation witherballRL = new ResourceLocation(MoreSnowballsMod.MODID, "wither_snowball");
        ResourceLocation gumballRL    = new ResourceLocation(MoreSnowballsMod.MODID,"gum_snowball");
        ResourceLocation customballRL = new ResourceLocation(MoreSnowballsMod.MODID,"custom_snowball");
        ResourceLocation zombieballRL = new ResourceLocation(MoreSnowballsMod.MODID,"zombie_snowball");

        // creating entries
        EntityEntry flintballEntity  = EntityEntryBuilder.create().entity(EntityFlintSnowball.class)
                .id(flintballRL, entityId++).name("Flint Snowball").tracker(64, 20, true).build();
        EntityEntry fireballEntity   = EntityEntryBuilder.create().entity(EntityFireSnowball.class)
                .id(fireballRL, entityId++).name("Fire Snowball").tracker(64, 20, true).build();
        EntityEntry poisonballEntity = EntityEntryBuilder.create().entity(EntityPoisonSnowball.class)
                .id(poisonballRL, entityId++).name("Poison Snowball").tracker(64, 20, true).build();
        EntityEntry tntballEntity    = EntityEntryBuilder.create().entity(EntityTNTSnowball.class)
                .id(tntballRL, entityId++).name("TNT Snowball").tracker(64, 20, true).build();
        EntityEntry witherballEntity = EntityEntryBuilder.create().entity(EntityWitherSnowball.class)
                .id(witherballRL, entityId++).name("Wither Snowball").tracker(64, 20, true).build();
        EntityEntry gumballEntity    = EntityEntryBuilder.create().entity(EntityGumSnowball.class)
                .id(gumballRL, entityId++).name("Gum Snowball").tracker(64, 20, true).build();
        EntityEntry customballEntity = EntityEntryBuilder.create().entity(EntityCustomSnowball.class)
                .id(customballRL, entityId++).name("Custom Snowball").tracker(64, 20, true).build();
        EntityEntry zombieballEntity = EntityEntryBuilder.create().entity(EntityZombieSnowball.class)
                .id(zombieballRL, entityId++).name("Zombie Snowball").tracker(64, 20, true).build();

        // registering
        ForgeRegistries.ENTITIES.register(flintballEntity);
        ForgeRegistries.ENTITIES.register(fireballEntity);
        ForgeRegistries.ENTITIES.register(poisonballEntity);
        ForgeRegistries.ENTITIES.register(tntballEntity);
        ForgeRegistries.ENTITIES.register(witherballEntity);
        ForgeRegistries.ENTITIES.register(gumballEntity);
        ForgeRegistries.ENTITIES.register(customballEntity);
        ForgeRegistries.ENTITIES.register(zombieballEntity);
    }
}
