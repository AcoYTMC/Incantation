package net.acoyt.incantation.client.render.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import net.minecraft.entity.AnimationState;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class IncaWingsModel extends Model {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart wing_left_1;
    private final ModelPart wing_left_2;
    private final ModelPart wing_right_1;
    private final ModelPart wing_right_2;

    public IncaWingsModel(ModelPart root, Function<Identifier, RenderLayer> layerFactory) {
        super(root, layerFactory);
        this.root = root.getChild("root");
        this.body = this.root.getChild("body");
        this.wing_left_1 = this.body.getChild("wing_left_1");
        this.wing_left_2 = this.wing_left_1.getChild("wing_left_2");
        this.wing_right_1 = this.body.getChild("wing_right_1");
        this.wing_right_2 = this.wing_right_1.getChild("wing_right_2");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, 0.0F));
        ModelPartData body = root.addChild("body", ModelPartBuilder.create(), ModelTransform.origin(0.0F, -12.0F, 0.0F));

        ModelPartData wing_left_1 = body.addChild("wing_left_1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, -7.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, -6.0F, 2.0F, 0.0F, -0.5236F, 0.0F));
        ModelPartData wing_left_2 = wing_left_1.addChild("wing_left_2", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.origin(4.0F, -2.0F, 0.0F));

        ModelPartData wing_right_1 = body.addChild("wing_right_1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -6.0F, 2.0F, 0.0F, 0.5236F, 0.0F));
        ModelPartData wing_right_2 = wing_right_1.addChild("wing_right_2", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.origin(-4.0F, -2.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void animate(AnimationState animationState, Animation animation, float age) {
        super.animate(animationState, animation, age);
    }

    public static class WingAnimations {
        public static final Animation idle = Animation.Builder.create(2.12F).looping()
                .addBoneAnimation("wing_left_1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -40.5F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.08F, AnimationHelper.createRotationalVector(0.0F, -40.1F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.16F, AnimationHelper.createRotationalVector(0.0F, -38.66F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.24F, AnimationHelper.createRotationalVector(0.0F, -35.51F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.32F, AnimationHelper.createRotationalVector(0.0F, -29.19F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.4F, AnimationHelper.createRotationalVector(0.0F, -16.5F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.48F, AnimationHelper.createRotationalVector(0.0F, -2.35F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.56F, AnimationHelper.createRotationalVector(0.0F, 4.62F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.64F, AnimationHelper.createRotationalVector(0.0F, 7.66F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.72F, AnimationHelper.createRotationalVector(0.0F, 8.75F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.8F, AnimationHelper.createRotationalVector(0.0F, 8.6F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.88F, AnimationHelper.createRotationalVector(0.0F, 7.44F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.96F, AnimationHelper.createRotationalVector(0.0F, 5.49F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.04F, AnimationHelper.createRotationalVector(0.0F, 2.91F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.12F, AnimationHelper.createRotationalVector(0.0F, -0.16F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.2F, AnimationHelper.createRotationalVector(0.0F, -3.62F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.28F, AnimationHelper.createRotationalVector(0.0F, -7.37F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.36F, AnimationHelper.createRotationalVector(0.0F, -11.31F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.44F, AnimationHelper.createRotationalVector(0.0F, -15.37F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.52F, AnimationHelper.createRotationalVector(0.0F, -19.46F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6F, AnimationHelper.createRotationalVector(0.0F, -23.5F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.68F, AnimationHelper.createRotationalVector(0.0F, -27.39F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.76F, AnimationHelper.createRotationalVector(0.0F, -31.04F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.84F, AnimationHelper.createRotationalVector(0.0F, -34.32F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.92F, AnimationHelper.createRotationalVector(0.0F, -37.11F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -39.2F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.08F, AnimationHelper.createRotationalVector(0.0F, -40.37F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.12F, AnimationHelper.createRotationalVector(0.0F, -40.5F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("wing_left_2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 4.2F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.08F, AnimationHelper.createRotationalVector(0.0F, -8.8F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.16F, AnimationHelper.createRotationalVector(0.0F, -18.21F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.24F, AnimationHelper.createRotationalVector(0.0F, -24.71F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.32F, AnimationHelper.createRotationalVector(0.0F, -28.23F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.36F, AnimationHelper.createRotationalVector(0.0F, -28.75F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.4F, AnimationHelper.createRotationalVector(0.0F, -27.85F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.48F, AnimationHelper.createRotationalVector(0.0F, -19.9F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.56F, AnimationHelper.createRotationalVector(0.0F, -4.76F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.64F, AnimationHelper.createRotationalVector(0.0F, 12.55F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.72F, AnimationHelper.createRotationalVector(0.0F, 26.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.8F, AnimationHelper.createRotationalVector(0.0F, 35.15F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.88F, AnimationHelper.createRotationalVector(0.0F, 42.28F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.96F, AnimationHelper.createRotationalVector(0.0F, 47.83F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.04F, AnimationHelper.createRotationalVector(0.0F, 52.04F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.12F, AnimationHelper.createRotationalVector(0.0F, 55.11F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.2F, AnimationHelper.createRotationalVector(0.0F, 57.15F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.28F, AnimationHelper.createRotationalVector(0.0F, 58.27F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.36F, AnimationHelper.createRotationalVector(0.0F, 58.55F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.44F, AnimationHelper.createRotationalVector(0.0F, 58.05F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.52F, AnimationHelper.createRotationalVector(0.0F, 56.61F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6F, AnimationHelper.createRotationalVector(0.0F, 54.01F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.68F, AnimationHelper.createRotationalVector(0.0F, 50.24F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.76F, AnimationHelper.createRotationalVector(0.0F, 45.28F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.84F, AnimationHelper.createRotationalVector(0.0F, 39.05F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.92F, AnimationHelper.createRotationalVector(0.0F, 31.45F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 22.3F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.08F, AnimationHelper.createRotationalVector(0.0F, 11.12F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.12F, AnimationHelper.createRotationalVector(0.0F, 4.2F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("wing_right_1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 39.5F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.08F, AnimationHelper.createRotationalVector(0.0F, 39.1F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.16F, AnimationHelper.createRotationalVector(0.0F, 37.66F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.24F, AnimationHelper.createRotationalVector(0.0F, 34.51F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.32F, AnimationHelper.createRotationalVector(0.0F, 28.19F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.4F, AnimationHelper.createRotationalVector(0.0F, 15.5F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.48F, AnimationHelper.createRotationalVector(0.0F, 1.35F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.56F, AnimationHelper.createRotationalVector(0.0F, -5.62F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.64F, AnimationHelper.createRotationalVector(0.0F, -8.66F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.72F, AnimationHelper.createRotationalVector(0.0F, -9.75F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.8F, AnimationHelper.createRotationalVector(0.0F, -9.6F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.88F, AnimationHelper.createRotationalVector(0.0F, -8.44F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.96F, AnimationHelper.createRotationalVector(0.0F, -6.49F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.04F, AnimationHelper.createRotationalVector(0.0F, -3.91F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.12F, AnimationHelper.createRotationalVector(0.0F, -0.84F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.2F, AnimationHelper.createRotationalVector(0.0F, 2.62F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.28F, AnimationHelper.createRotationalVector(0.0F, 6.37F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.36F, AnimationHelper.createRotationalVector(0.0F, 10.31F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.44F, AnimationHelper.createRotationalVector(0.0F, 14.37F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.52F, AnimationHelper.createRotationalVector(0.0F, 18.46F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.68F, AnimationHelper.createRotationalVector(0.0F, 26.39F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.76F, AnimationHelper.createRotationalVector(0.0F, 30.04F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.84F, AnimationHelper.createRotationalVector(0.0F, 33.32F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.92F, AnimationHelper.createRotationalVector(0.0F, 36.11F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 38.2F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.08F, AnimationHelper.createRotationalVector(0.0F, 39.37F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.12F, AnimationHelper.createRotationalVector(0.0F, 39.5F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("wing_right_2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -4.2F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.08F, AnimationHelper.createRotationalVector(0.0F, 8.8F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.16F, AnimationHelper.createRotationalVector(0.0F, 18.21F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.24F, AnimationHelper.createRotationalVector(0.0F, 24.71F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.32F, AnimationHelper.createRotationalVector(0.0F, 28.23F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.36F, AnimationHelper.createRotationalVector(0.0F, 28.75F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.4F, AnimationHelper.createRotationalVector(0.0F, 27.85F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.48F, AnimationHelper.createRotationalVector(0.0F, 19.9F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.56F, AnimationHelper.createRotationalVector(0.0F, 4.76F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.64F, AnimationHelper.createRotationalVector(0.0F, -12.55F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.72F, AnimationHelper.createRotationalVector(0.0F, -26.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.8F, AnimationHelper.createRotationalVector(0.0F, -35.15F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.88F, AnimationHelper.createRotationalVector(0.0F, -42.28F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.96F, AnimationHelper.createRotationalVector(0.0F, -47.83F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.04F, AnimationHelper.createRotationalVector(0.0F, -52.04F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.12F, AnimationHelper.createRotationalVector(0.0F, -55.11F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.2F, AnimationHelper.createRotationalVector(0.0F, -57.15F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.28F, AnimationHelper.createRotationalVector(0.0F, -58.27F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.36F, AnimationHelper.createRotationalVector(0.0F, -58.55F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.44F, AnimationHelper.createRotationalVector(0.0F, -58.05F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.52F, AnimationHelper.createRotationalVector(0.0F, -56.61F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6F, AnimationHelper.createRotationalVector(0.0F, -54.01F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.68F, AnimationHelper.createRotationalVector(0.0F, -50.24F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.76F, AnimationHelper.createRotationalVector(0.0F, -45.28F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.84F, AnimationHelper.createRotationalVector(0.0F, -39.05F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.92F, AnimationHelper.createRotationalVector(0.0F, -31.45F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -22.3F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.08F, AnimationHelper.createRotationalVector(0.0F, -11.12F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.12F, AnimationHelper.createRotationalVector(0.0F, -4.2F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .build();
    }
}
