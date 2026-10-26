package com.cs_club.minecraft_alien_mod.entity.client;


import com.cs_club.minecraft_alien_mod.entity.custom.HeadcrabEntity;
import com.cs_club.minecraft_alien_mod.minecraftalienmod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HeadcrabRenderer extends MobRenderer<HeadcrabEntity, HeadcrabModel<HeadcrabEntity>> {

    public HeadcrabRenderer(EntityRendererProvider.Context context ) {
        super(context, new HeadcrabModel<>(context.bakeLayer(HeadcrabModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(HeadcrabEntity headcrab) {
        return ResourceLocation.fromNamespaceAndPath(minecraftalienmod.MODID, "textures/entity/headcrab/headcrabtex.png");
    }

    @Override
    public void render(HeadcrabEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
