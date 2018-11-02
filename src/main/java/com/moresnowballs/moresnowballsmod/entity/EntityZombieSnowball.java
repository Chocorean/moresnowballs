package com.moresnowballs.moresnowballsmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityZombieSnowball extends EntityThrowable {
    public EntityZombieSnowball(World worldIn)
    {
        super(worldIn);
    }

    public EntityZombieSnowball(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityZombieSnowball(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesSnowball(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "ZombieSnowball");
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote) {
            Entity entity = new EntityZombie(this.world);
            entity.setAlwaysRenderNameTag(true);
            entity.setPosition(this.posX,this.posY,this.posZ);

            this.world.spawnEntity(entity);
            entity.setCustomNameTag("Le bouffeur de chattes");
            entity.setGlowing(true);

            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }
}
