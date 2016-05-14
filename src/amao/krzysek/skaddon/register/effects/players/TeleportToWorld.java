package amao.krzysek.skaddon.register.effects.players;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class TeleportToWorld extends Effect {

    Expression<?> player;
    Expression<?> world;
    Expression<?> location;

    @Override
    protected void execute(Event e) {
        Player player = (Player) this.player.getSingle(e);
        String world = (String) this.world.getSingle(e);
        Location location = (Location) this.location.getSingle(e);
        if(Bukkit.getServer().getWorld(world) != null) {
            if(location == null)
                player.teleport(new Location(Bukkit.getServer().getWorld(world), Bukkit.getServer().getWorld(world).getSpawnLocation().getX(), Bukkit.getServer().getWorld(world).getSpawnLocation().getY(), Bukkit.getServer().getWorld(world).getSpawnLocation().getZ()));
            else player.teleport(new Location(Bukkit.getServer().getWorld(world), location.getX(), location.getY(), location.getZ()));
        }
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = expr[0];
        world = expr[1];
        location = expr[2];
        return true;
    }


}
