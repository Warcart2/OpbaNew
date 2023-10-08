package net.warcar.opba.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelTheWorldModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("opba", "model_the_world_model"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart rightArm;
	public final ModelPart leftArm;
	public final ModelPart rightLeg;
	public final ModelPart leftLeg;

	public ModelTheWorldModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition headpiece = head.addOrReplaceChild("headpiece", CubeListBuilder.create().texOffs(82, 2).addBox(-4.0F, -1.2F, 1.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)).texOffs(90, 22).mirror()
				.addBox(3.0F, -6.2F, 1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(65, 22).addBox(-4.0F, -6.2F, 1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -2.0F, -5.3F));
		PartDefinition slope = headpiece.addOrReplaceChild("slope",
				CubeListBuilder.create().texOffs(64, 9).addBox(-4.0F, 0.2F, 0.2F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.2F)).texOffs(56, 7).mirror().addBox(-4.2F, 0.06F, 6.35F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-1.0F)).mirror(false)
						.texOffs(56, 14).mirror().addBox(-4.2F, 2.21F, 5.25F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-1.0F)).mirror(false).texOffs(96, 14).addBox(3.2F, 2.21F, 5.25F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-1.0F)).texOffs(96, 7)
						.addBox(3.2F, 0.06F, 6.35F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-1.0F)),
				PartPose.offsetAndRotation(0.0F, -6.4F, 1.3F, 0.3578F, 0.0F, 0.0F));
		PartDefinition slopeBack = slope.addOrReplaceChild("slopeBack", CubeListBuilder.create().texOffs(65, 1).addBox(-4.0F, 0.2F, 0.2F, 8.0F, 7.0F, 0.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 8.4F, -0.3578F, 0.0F, 0.0F));
		PartDefinition slope2 = headpiece.addOrReplaceChild("slope2",
				CubeListBuilder.create().texOffs(98, 14).addBox(-4.0F, -3.2F, 0.2F, 8.0F, 3.0F, 7.0F, new CubeDeformation(0.2F)).texOffs(82, 0).addBox(-4.0F, -1.2F, 5.9372F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 2.7F, 0.2755F, 0.0F, 0.0F));
		PartDefinition faceRight = headpiece.addOrReplaceChild("faceRight", CubeListBuilder.create().texOffs(69, 21).addBox(0.2F, 0.2F, 0.2F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(-4.2F, -6.4F, 1.3F, 0.0F, 0.3023F, 0.0F));
		PartDefinition faceLeft = headpiece.addOrReplaceChild("faceLeft", CubeListBuilder.create().texOffs(80, 21).mirror().addBox(-4.2F, 0.2F, 0.2F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false),
				PartPose.offsetAndRotation(4.2F, -6.4F, 1.3F, 0.0F, -0.3023F, 0.0F));
		PartDefinition leftCable = head.addOrReplaceChild("leftCable", CubeListBuilder.create().texOffs(13, 16).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(13, 25).mirror()
				.addBox(-0.5F, 1.0F, 1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.25F, -3.3F, 0.25F, 0.0873F, 0.1309F, -1.1345F));
		PartDefinition rightCable = head.addOrReplaceChild("rightCable",
				CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 25).addBox(-0.5F, 1.0F, 1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.25F, -3.3F, 0.25F, 0.0873F, -0.1309F, 1.2217F));
		PartDefinition heartSmallHead = head.addOrReplaceChild("heartSmallHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.55F, -4.0F));
		PartDefinition smallHeartCube4 = heartSmallHead.addOrReplaceChild("smallHeartCube4", CubeListBuilder.create().texOffs(4, 6).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition smallHeartCube5 = heartSmallHead.addOrReplaceChild("smallHeartCube5", CubeListBuilder.create().texOffs(4, 6).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(0.3F, -0.3F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition smallHeartCube6 = heartSmallHead.addOrReplaceChild("smallHeartCube6", CubeListBuilder.create().texOffs(4, 6).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(-0.3F, -0.3F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 64).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 64).addBox(-3.5F, 1.1F, -2.0F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.4F)).texOffs(24, 73)
						.addBox(-2.5F, 4.0F, -2.3F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(49, 65).mirror().addBox(2.0F, 0.0F, -2.5F, 1.0F, 10.0F, 5.0F, new CubeDeformation(0.25F)).mirror(false).texOffs(36, 65)
						.addBox(-3.0F, 0.0F, -2.5F, 1.0F, 10.0F, 5.0F, new CubeDeformation(0.25F)).texOffs(9, 80).mirror().addBox(0.5F, 1.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 80)
						.addBox(-2.5F, 1.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition heartLargeAbdomen = body.addOrReplaceChild("heartLargeAbdomen", CubeListBuilder.create(), PartPose.offset(0.0F, 13.5F, -1.75F));
		PartDefinition largeHeartCube1 = heartLargeAbdomen.addOrReplaceChild("largeHeartCube1", CubeListBuilder.create().texOffs(21, 80).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition largeHeartCube2 = heartLargeAbdomen.addOrReplaceChild("largeHeartCube2", CubeListBuilder.create().texOffs(21, 80).addBox(0.0F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartSmallAbdomen = body.addOrReplaceChild("heartSmallAbdomen", CubeListBuilder.create(), PartPose.offset(0.0F, 11.3F, -2.05F));
		PartDefinition smallHeartCube1 = heartSmallAbdomen.addOrReplaceChild("smallHeartCube1", CubeListBuilder.create().texOffs(17, 80).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition smallHeartCube2 = heartSmallAbdomen.addOrReplaceChild("smallHeartCube2", CubeListBuilder.create().texOffs(17, 80).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(0.3F, -0.3F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition smallHeartCube3 = heartSmallAbdomen.addOrReplaceChild("smallHeartCube3", CubeListBuilder.create().texOffs(17, 80).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(-0.3F, -0.3F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm",
				CubeListBuilder.create().texOffs(0, 108).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 110).addBox(-2.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-6.0F, 2.0F, 0.0F));
		PartDefinition heartRightArm = rightArm.addOrReplaceChild("heartRightArm", CubeListBuilder.create(), PartPose.offset(0.0F, 3.8F, 1.8F));
		PartDefinition heartCube1 = heartRightArm.addOrReplaceChild("heartCube1", CubeListBuilder.create().texOffs(16, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartCube2 = heartRightArm.addOrReplaceChild("heartCube2", CubeListBuilder.create().texOffs(16, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(0.5F, -0.5F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartCube3 = heartRightArm.addOrReplaceChild("heartCube3", CubeListBuilder.create().texOffs(16, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(-0.5F, -0.5F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rightArmJoint = rightArm.addOrReplaceChild("rightArmJoint", CubeListBuilder.create().texOffs(0, 102).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition rightForeArm = rightArm.addOrReplaceChild("rightForeArm",
				CubeListBuilder.create().texOffs(0, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.001F)).texOffs(16, 119).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(0, 96)
						.addBox(-3.0F, 2.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.4F)).texOffs(10, 97).addBox(-2.5F, 5.1F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.2F)),
				PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm",
				CubeListBuilder.create().texOffs(32, 108).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 110).mirror().addBox(0.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
				PartPose.offset(6.0F, 2.0F, 0.0F));
		PartDefinition heartLeftArm = leftArm.addOrReplaceChild("heartLeftArm", CubeListBuilder.create(), PartPose.offset(0.0F, 3.8F, 1.8F));
		PartDefinition heartCube4 = heartLeftArm.addOrReplaceChild("heartCube4", CubeListBuilder.create().texOffs(48, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartCube5 = heartLeftArm.addOrReplaceChild("heartCube5", CubeListBuilder.create().texOffs(48, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(0.5F, -0.5F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartCube6 = heartLeftArm.addOrReplaceChild("heartCube6", CubeListBuilder.create().texOffs(48, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(-0.5F, -0.5F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leftArmJoint = leftArm.addOrReplaceChild("leftArmJoint", CubeListBuilder.create().texOffs(32, 102).mirror().addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false),
				PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition leftForeArm = leftArm.addOrReplaceChild("leftForeArm",
				CubeListBuilder.create().texOffs(32, 118).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.001F)).mirror(false).texOffs(48, 119).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false).texOffs(32, 96).mirror().addBox(1.0F, 2.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.4F)).mirror(false).texOffs(42, 97).mirror()
						.addBox(1.5F, 5.1F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false),
				PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg",
				CubeListBuilder.create().texOffs(64, 108).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(80, 108).addBox(-2.6F, -1.25F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition heartLeftLeg = rightLeg.addOrReplaceChild("heartLeftLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -1.8F));
		PartDefinition heartCube7 = heartLeftLeg.addOrReplaceChild("heartCube7", CubeListBuilder.create().texOffs(64, 120).addBox(0.0F, -1.05F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(0.0F, 0.05F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartCube8 = heartLeftLeg.addOrReplaceChild("heartCube8", CubeListBuilder.create().texOffs(64, 120).addBox(0.0F, -1.05F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(0.5F, -0.45F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartCube9 = heartLeftLeg.addOrReplaceChild("heartCube9", CubeListBuilder.create().texOffs(64, 120).addBox(0.0F, -1.05F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(-0.5F, -0.45F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rightLegJoint = rightLeg.addOrReplaceChild("rightLegJoint", CubeListBuilder.create().texOffs(64, 102).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		PartDefinition rightLowerLeg = rightLeg.addOrReplaceChild("rightLowerLeg", CubeListBuilder.create().texOffs(64, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg",
				CubeListBuilder.create().texOffs(96, 108).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(112, 108).mirror().addBox(1.6F, -1.75F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition heartRightLeg = leftLeg.addOrReplaceChild("heartRightLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -1.8F));
		PartDefinition heartCube10 = heartRightLeg.addOrReplaceChild("heartCube10", CubeListBuilder.create().texOffs(96, 120).addBox(0.0F, -1.05F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(0.0F, 0.05F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartCube11 = heartRightLeg.addOrReplaceChild("heartCube11", CubeListBuilder.create().texOffs(96, 120).addBox(0.0F, -1.05F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(0.5F, -0.45F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition heartCube12 = heartRightLeg.addOrReplaceChild("heartCube12", CubeListBuilder.create().texOffs(96, 120).addBox(0.0F, -1.05F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)),
				PartPose.offsetAndRotation(-0.5F, -0.45F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leftLegJoint = leftLeg.addOrReplaceChild("leftLegJoint", CubeListBuilder.create().texOffs(96, 102).mirror().addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false),
				PartPose.offset(0.0F, 6.0F, 0.0F));
		PartDefinition leftLowerLeg = leftLeg.addOrReplaceChild("leftLowerLeg", CubeListBuilder.create().texOffs(96, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
