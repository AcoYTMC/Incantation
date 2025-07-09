package net.acoyt.incantation.compat;

import eu.midnightdust.lib.config.MidnightConfig;

public class IncaConfig extends MidnightConfig {
    public static final String client = "client";
    public static final String common = "common";

    @Entry(category = client)
    public static boolean allowParticles = true;

    @Entry(category = common, min = 0, max = 5)
    public static int particleMultiplier = 1;
}
