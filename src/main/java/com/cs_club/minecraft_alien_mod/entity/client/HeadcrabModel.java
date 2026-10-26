package com.cs_club.minecraft_alien_mod.entity.client;

import com.cs_club.minecraft_alien_mod.entity.custom.HeadcrabEntity;
import com.cs_club.minecraft_alien_mod.minecraftalienmod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static com.cs_club.minecraft_alien_mod.minecraftalienmod.MODID;

public class HeadcrabModel<T extends Entity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(MODID, "headcrab"), "main"
    );
    private final ModelPart Headcrab;
    private final ModelPart body;
    private final ModelPart fleg;
    private final ModelPart fleg2;
    private final ModelPart leg;
    private final ModelPart leg2;

    public HeadcrabModel(ModelPart root) {
        this.Headcrab = root.getChild("Headcrab");
        this.body = this.Headcrab.getChild("body");
        this.fleg = this.Headcrab.getChild("fleg");
        this.fleg2 = this.Headcrab.getChild("fleg2");
        this.leg = this.Headcrab.getChild("leg");
        this.leg2 = this.Headcrab.getChild("leg2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Headcrab = partdefinition.addOrReplaceChild("Headcrab", CubeListBuilder.create(), PartPose.offset(0.0F, 24.3F, 2.0F));

        PartDefinition body = Headcrab.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition fleg = Headcrab.addOrReplaceChild("fleg", CubeListBuilder.create().texOffs(20, 26).addBox(-1.0F, -0.75F, -5.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -3.3F, -3.0F));

        PartDefinition cube_r1 = fleg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -3.0F, 1.0036F, 0.0F, 0.0F));

        PartDefinition fleg2 = Headcrab.addOrReplaceChild("fleg2", CubeListBuilder.create().texOffs(20, 26).addBox(0.0F, -0.75F, -5.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -3.3F, -3.0F));

        PartDefinition cube_r2 = fleg2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, -3.0F, 1.0036F, 0.0F, 0.0F));

        PartDefinition leg = Headcrab.addOrReplaceChild("leg", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, 1.65F, 0.1F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -6.0F, 4.0F));

        PartDefinition cube_r3 = leg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.8727F, 0.0F, 0.0F));

        PartDefinition leg2 = Headcrab.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, 1.65F, 0.1F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -6.0F, 4.0F));

        PartDefinition cube_r4 = leg2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.8727F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public ModelPart root() {
        return this.Headcrab;
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        HeadcrabEntity headcrab = (HeadcrabEntity) entity;

        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(HeadcrabAnimations.ANIM_HEADC_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(headcrab.idleAnimationState, HeadcrabAnimations.ANIM_HEADC_IDLE, ageInTicks, 1f);
        this.animate(headcrab.attackAnimationState, HeadcrabAnimations.ANIM_HEADC_ATTACK, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Headcrab.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}