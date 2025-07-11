package net.acoyt.incantation.util;

import net.acoyt.incantation.Incantation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public record CosmeticInfo(UUID uuid, boolean wings) {
    public static final Map<UUID, CosmeticInfo> cosmeticData = new LinkedHashMap<>();

    public static CosmeticInfo getOrDefault(UUID uuid) {
        return cosmeticData.getOrDefault(uuid, new CosmeticInfo(uuid, false));
    }

    public static CosmeticInfo getDefault(UUID uuid) {
        return new CosmeticInfo(uuid, false);
    }

    public CosmeticInfo withWings(boolean wings) {
        return Incantation.isSupporter(this.uuid) ? new CosmeticInfo(this.uuid, wings) : new CosmeticInfo(this.uuid, this.wings);
    }
}
