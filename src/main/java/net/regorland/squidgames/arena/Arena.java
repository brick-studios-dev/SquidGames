package net.regorland.squidgames.arena;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.player.player.GamePlayer;
import org.bukkit.Location;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Accessors(chain = true)
public class Arena {
    @Getter @Setter private ArenaState arenaState;
    @Getter @Setter private ArenaType arenaType;

    public Arena() {
        this.arenaState = ArenaState.WAITING;
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