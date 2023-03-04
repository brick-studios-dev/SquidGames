package net.regorland.squidgames.game;

import lombok.Getter;
import lombok.Setter;
import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.player.player.GamePlayer;
import org.bukkit.Location;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class GameArena {
    @Getter @Setter private GameState gameState;
    @Getter @Setter private GameType gameType;

    public GameArena() {
        this.gameState = GameState.WAITING;
    }
    public List<GamePlayer> getPlayers() {
        return SquidGames.getInstance().getGamePlayerManager().getList().stream()
                .filter(target -> target.getGameArena().equals(this)).collect(Collectors.toList());
    }
    public void doGlobally(Consumer<GamePlayer> consumer) {
        getPlayers().forEach(consumer);
    }
    public void teleport(Location bukkitLocation) {
        doGlobally(gamePlayer -> gamePlayer.getBukkitPlayer().teleport(bukkitLocation));
    }
}
