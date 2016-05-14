package amao.krzysek.skaddon.register.conditions.players;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class IsInWorld extends Condition {

    Expression<?> player;
    Expression<?> world;

    @Override
    public boolean check(Event e) {
        Player player = (Player) this.player.getSingle(e);
        String world = (String) this.world.getSingle(e);
        if(Bukkit.getPlayer(player.getName()) != null) {
            if(Bukkit.getWorld(world) != null) {
                World isIn = player.getWorld();
                World shouldBe = Bukkit.getWorld(world);
                if(isIn != shouldBe)
                    return false;
                else return true;
            }
        }
        return false;
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = expr[0];
        world = expr[1];
        return true;
    }

}
