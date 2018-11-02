package com.moresnowballs.moresnowballsmod.event;

import com.moresnowballs.moresnowballsmod.MoreSnowballsMod;
import com.moresnowballs.moresnowballsmod.entity.EntityCustomSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// Gestion des events coté client
public class EventHandlerClient {
    // replace vanilla snowball entity by a more realistic one
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void replaceVanillaSnowball(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        World world = event.getWorld();
        if (entity instanceof EntitySnowball) {
            if (!world.isRemote) {
                // creating new entity
                EntityLivingBase thrower = ((EntitySnowball) entity).getThrower();
                EntityCustomSnowball entitysnowball = new EntityCustomSnowball(world, thrower);
                entitysnowball.shoot(thrower, thrower.rotationPitch, thrower.rotationYaw, 0.0F, 1.5F, 1.0F);
                world.spawnEntity(entitysnowball);
            }
            event.setCanceled(true);
        }
    }
}
