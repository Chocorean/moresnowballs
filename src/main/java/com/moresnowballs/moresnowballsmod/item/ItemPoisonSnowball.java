package com.moresnowballs.moresnowballsmod.item;

import com.moresnowballs.moresnowballsmod.entity.EntityPoisonSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemPoisonSnowball extends SnowballBase {
    public ItemPoisonSnowball(String name) {
        super(name);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            EntityPoisonSnowball entitysnowball = new EntityPoisonSnowball(worldIn, playerIn);
            entitysnowball.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(entitysnowball);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
