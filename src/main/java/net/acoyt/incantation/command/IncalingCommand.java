package net.acoyt.incantation.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import net.acoyt.incantation.cca.IncalingComponent;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class IncalingCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess acc, CommandManager.RegistrationEnvironment dedicated) {
        dispatcher.register(literal("incaling").requires(source -> source.hasPermissionLevel(2))
                .then(literal("set")
                        .then(argument("players", EntityArgumentType.players())
                                .then(argument("value", BoolArgumentType.bool())
                                        .executes(context -> {
                                            for (PlayerEntity player : EntityArgumentType.getPlayers(context, "players")) {
                                                IncalingComponent incaling = IncalingComponent.get(player);

                                                boolean bl = BoolArgumentType.getBool(context, "value");
                                                incaling.setIncaling(bl);
                                            }

                                            return Command.SINGLE_SUCCESS;
                                        })
                                )
                        )
                ).then(literal("get")
                        .then(argument("player", EntityArgumentType.player())
                                .executes(context -> {
                                    ServerCommandSource source = context.getSource();
                                    ServerPlayerEntity serverPlayer = source.getPlayerOrThrow();
                                    PlayerEntity player = EntityArgumentType.getPlayer(context, "player");

                                    IncalingComponent incaling = IncalingComponent.get(player);
                                    boolean bl = incaling.isIncaling();

                                    serverPlayer.sendMessage(Text.literal("Player: ").append(player.getDisplayName()).append(" is " + (bl ? "" : "not ") + "an Incaling!"), false);

                                    return Command.SINGLE_SUCCESS;
                                })
                        )
                )
        );
    }
}
