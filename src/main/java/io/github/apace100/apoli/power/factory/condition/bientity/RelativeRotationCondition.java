package io.github.apace100.apoli.power.factory.condition.bientity;

import io.github.apace100.apoli.Apoli;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.util.Comparison;
import io.github.apace100.apoli.util.ExtendSerialzableDataType;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;
import java.util.function.Function;

public class RelativeRotationCondition {

    public static boolean condition(SerializableData.Instance data, Pair<Entity, Entity> pair) {
        RotationType actorRotation = data.get("actor_rotation");
        RotationType targetRotation = data.get("target_rotation");
        Vec3d vec0 = actorRotation.getRotation(pair.getLeft());
        Vec3d vec1 = targetRotation.getRotation(pair.getRight());
        EnumSet<Direction.Axis> axes = data.get("axes");
        vec0 = reduceAxes(vec0, axes);
        vec1 = reduceAxes(vec1, axes);
        double angle = getAngleBetween(vec0, vec1);
        Comparison comparison = data.get("comparison");
        double compareTo = data.getDouble("compare_to");
        return comparison.compare(angle, compareTo);
    }

    private static double getAngleBetween(Vec3d a, Vec3d b) {
        double dot = a.dotProduct(b);
        return dot / (a.length() * b.length());
    }

    private static Vec3d reduceAxes(Vec3d vector, EnumSet<Direction.Axis> axesToKeep) {
        return new Vec3d(
            axesToKeep.contains(Direction.Axis.X) ? vector.x : 0,
            axesToKeep.contains(Direction.Axis.Y) ? vector.y : 0,
            axesToKeep.contains(Direction.Axis.Z) ? vector.z : 0
        );
    }

    public static ConditionFactory<Pair<Entity, Entity>> getFactory() {
        return new ConditionFactory<>(Apoli.identifier("relative_rotation"),
            new SerializableData()
                .add("axes", ExtendSerialzableDataType.AXIS_SET, EnumSet.allOf(Direction.Axis.class))
                .add("actor_rotation", SerializableDataType.enumValue(RotationType.class), RotationType.HEAD)
                .add("target_rotation", SerializableDataType.enumValue(RotationType.class), RotationType.BODY)
                .add("comparison", ApoliDataTypes.COMPARISON)
                .add("compare_to", SerializableDataTypes.DOUBLE),
            RelativeRotationCondition::condition
        );
    }

    private static Vec3d getRotationVector(float pitch, float yaw) {
        float f = pitch * ((float)Math.PI / 180);
        float g = -yaw * ((float)Math.PI / 180);
        float h = MathHelper.cos(g);
        float i = MathHelper.sin(g);
        float j = MathHelper.cos(f);
        float k = MathHelper.sin(f);
        return new Vec3d(i * j, -k, h * j);
    }

    public enum RotationType {
        HEAD(e -> e.getRotationVec(1.0F)), BODY(e -> {
            if(e instanceof LivingEntity l) {
                return getRotationVector(0F, l.bodyYaw);
            } else {
                return e.getRotationVec(1.0F);
            }
        });

        private final Function<Entity, Vec3d> function;

        RotationType(Function<Entity, Vec3d> function) {
            this.function = function;
        }

        public Vec3d getRotation(Entity entity) {
            return function.apply(entity);
        }
    }
}