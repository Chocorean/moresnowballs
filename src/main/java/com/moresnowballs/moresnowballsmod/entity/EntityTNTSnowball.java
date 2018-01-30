package com.moresnowballs.moresnowballsmod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityTNTSnowball extends EntityThrowable {
    public EntityTNTSnowball(World worldIn)
    {
        super(worldIn);
    }

    public EntityTNTSnowball(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityTNTSnowball(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesSnowball(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "PoisonSnowball");
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
                this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
            Explosion explosionIn = new Explosion(this.world,this.thrower,this.posX,this.posY,this.posZ,0.5F,false,true);
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(this.world, (double)((float)this.posX + 0.5F), this.posY, (double)((float)this.posZ + 0.5F), explosionIn.getExplosivePlacedBy());
            entitytntprimed.setFuse((short)(this.world.rand.nextInt(entitytntprimed.getFuse() / 4) + entitytntprimed.getFuse() / 8));
            this.world.createExplosion(entitytntprimed, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 1.0F, true);

            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }
}
