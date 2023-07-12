//        Copyright (c) 2021 apace100
//
//        Use of this source code is governed by an MIT-style
//        license that can be found in the LICENSE file or at
//        https://github.com/apace100/calio/blob/dae0a7cea6e67907c137f1f427adb465eb1934b0/LICENSE.
//
//        This is backported code from apace100/calio commit: dae0a7c
//        https://github.com/apace100/calio/commit/dae0a7cea6e67907c137f1f427adb465eb1934b0

package io.github.apace100.apoli.util;

import com.google.common.collect.HashBiMap;
import io.github.apace100.calio.data.SerializableDataType;
import net.minecraft.block.Material;
import net.minecraft.util.math.Direction;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import static io.github.apace100.calio.data.SerializableDataTypes.AXIS;

public class ExtendSerialzableDataType extends SerializableDataType {
    public static final SerializableDataType<EnumSet<Direction.Axis>> AXIS_SET = SerializableDataType.enumSet(Direction.Axis.class, AXIS);

    private static final HashMap<String, Material> MATERIAL_MAP;
    static {
        MATERIAL_MAP = new HashMap<>();
        MATERIAL_MAP.put("air", Material.AIR);
        MATERIAL_MAP.put("structure_void", Material.STRUCTURE_VOID);
        MATERIAL_MAP.put("portal", Material.PORTAL);
        MATERIAL_MAP.put("carpet", Material.CARPET);
        MATERIAL_MAP.put("plant", Material.PLANT);
        MATERIAL_MAP.put("underwater_plant", Material.UNDERWATER_PLANT);
        MATERIAL_MAP.put("replaceable_plant", Material.REPLACEABLE_PLANT);
        MATERIAL_MAP.put("nether_shoots", Material.NETHER_SHOOTS);
        MATERIAL_MAP.put("replaceable_underwater_plant", Material.REPLACEABLE_UNDERWATER_PLANT);
        MATERIAL_MAP.put("water", Material.WATER);
        MATERIAL_MAP.put("bubble_column", Material.BUBBLE_COLUMN);
        MATERIAL_MAP.put("lava", Material.LAVA);
        MATERIAL_MAP.put("snow_layer", Material.SNOW_LAYER);
        MATERIAL_MAP.put("fire", Material.FIRE);
        MATERIAL_MAP.put("decoration", Material.DECORATION);
        MATERIAL_MAP.put("cobweb", Material.COBWEB);
        MATERIAL_MAP.put("sculk", Material.SCULK);
        MATERIAL_MAP.put("redstone_lamp", Material.REDSTONE_LAMP);
        MATERIAL_MAP.put("organic_product", Material.ORGANIC_PRODUCT);
        MATERIAL_MAP.put("soil", Material.SOIL);
        MATERIAL_MAP.put("solid_organic", Material.SOLID_ORGANIC);
        MATERIAL_MAP.put("dense_ice", Material.DENSE_ICE);
        MATERIAL_MAP.put("aggregate", Material.AGGREGATE);
        MATERIAL_MAP.put("sponge", Material.SPONGE);
        MATERIAL_MAP.put("shulker_box", Material.SHULKER_BOX);
        MATERIAL_MAP.put("wood", Material.WOOD);
        MATERIAL_MAP.put("nether_wood", Material.NETHER_WOOD);
        MATERIAL_MAP.put("bamboo_sapling", Material.BAMBOO_SAPLING);
        MATERIAL_MAP.put("bamboo", Material.BAMBOO);
        MATERIAL_MAP.put("wool", Material.WOOL);
        MATERIAL_MAP.put("tnt", Material.TNT);
        MATERIAL_MAP.put("leaves", Material.LEAVES);
        MATERIAL_MAP.put("glass", Material.GLASS);
        MATERIAL_MAP.put("ice", Material.ICE);
        MATERIAL_MAP.put("cactus", Material.CACTUS);
        MATERIAL_MAP.put("stone", Material.STONE);
        MATERIAL_MAP.put("metal", Material.METAL);
        MATERIAL_MAP.put("snow_block", Material.SNOW_BLOCK);
        MATERIAL_MAP.put("repair_station", Material.REPAIR_STATION);
        MATERIAL_MAP.put("barrier", Material.BARRIER);
        MATERIAL_MAP.put("piston", Material.PISTON);
        MATERIAL_MAP.put("moss_block", Material.MOSS_BLOCK);
        MATERIAL_MAP.put("gourd", Material.GOURD);
        MATERIAL_MAP.put("egg", Material.EGG);
        MATERIAL_MAP.put("cake", Material.CAKE);
        MATERIAL_MAP.put("amethyst", Material.AMETHYST);
        MATERIAL_MAP.put("powder_snow", Material.POWDER_SNOW);
    }

    public static final SerializableDataType<Material> MATERIAL = SerializableDataType.mapped(Material.class, HashBiMap.create(
            MATERIAL_MAP
    ));

    public static final SerializableDataType<List<Material>> MATERIALS = SerializableDataType.list(MATERIAL);

    public ExtendSerialzableDataType(Class dataClass, BiConsumer send, Function receive, Function read) {
        super(dataClass, send, receive, read);
    }
}
