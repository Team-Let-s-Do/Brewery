package net.satisfy.brewery.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.satisfy.brewery.util.BreweryIdentifier;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class BrewfestHatModel<T extends Entity> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new BreweryIdentifier("brewfest_hat"), "main");

	private final ModelPart brewfest_hat;
	public BrewfestHatModel(ModelPart root) {
		this.brewfest_hat = root.getChild("brewfest_hat");
	}
	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition brewfest_hat = partdefinition.addOrReplaceChild("brewfest_hat", CubeListBuilder.create().texOffs(-14, 15).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.0F, -4.2F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.2F))
				.texOffs(-1, 4).addBox(-4.05F, -2.21F, -4.05F, 8.1F, 2.0F, 8.1F, new CubeDeformation(0.2F))
				.texOffs(22, 22).addBox(4.21F, -7.4F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void renderToBuffer(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		brewfest_hat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}