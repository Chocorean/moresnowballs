package com.moresnowballs.moresnowballsmod.model;


import com.moresnowballs.moresnowballsmod.entity.EntityFlintSnowball;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelFlintSnowball extends ModelBase {
    private ModelRenderer renderer;

    public ModelFlintSnowball() {
        this.textureWidth = 16;
        this.textureHeight = 16;

        this.renderer = new ModelRenderer(this, 0, 0);
        this.renderer.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.renderer.addBox(0.0F, 0.0F, 0.0F, 16, 16, 1);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
        this.renderer.render(scale);
    }
}