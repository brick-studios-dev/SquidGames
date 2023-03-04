package net.regorland.squidgames.arena;

import lombok.Getter;
import net.regorland.squidgames.game.GameActions;
import net.regorland.squidgames.game.games.RedGreenLightGame;

public enum ArenaType {
    RED_LIGHT_GREEN_LIGHT("red_green_light", RedGreenLightGame.class);

    @Getter private final String identifier;
    @Getter private final Class<? extends GameActions> baseGame;

    ArenaType(String identifier, Class<? extends GameActions> baseGame) {
        this.identifier = identifier;
        this.baseGame = baseGame;
    }
}