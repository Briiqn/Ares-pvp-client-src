/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticPetSlime
 *  com.aresclient.user.cosmetic.imp.CosmeticPetSlime$BlazeModel
 *  com.aresclient.utils.config.ConfigManager
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.user.cosmetic.imp.CosmeticPetSlime;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticPetSlime
extends Cosmetic {
    BlazeModel blazemodel;
    public static final ResourceLocation TEXTURE = new ResourceLocation("Ares/slime.png");

    public CosmeticPetSlime(RenderPlayer playerRendererIn) {
        super(playerRendererIn);
        this.blazemodel = new BlazeModel(playerRendererIn);
    }

    public void render(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float HeadPitch, float scale) {
        GlStateManager.pushMatrix();
        this.playerRenderer.bindTexture(TEXTURE);
        if (ConfigManager.settings.Shoulder == 1) {
            GlStateManager.translate((double)0.7, (double)-0.6, (double)0.0);
        } else {
            GlStateManager.translate((double)-0.7, (double)-0.6, (double)0.0);
        }
        if (entitylivingbaseIn.isSneaking()) {
            GlStateManager.translate((double)0.0, (double)0.045, (double)0.0);
        }
        this.blazemodel.render((Entity)entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, HeadPitch, HeadPitch, scale);
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    public int getCosmeticId() {
        return 0;
    }
}

