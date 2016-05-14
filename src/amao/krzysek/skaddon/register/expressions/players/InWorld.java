package amao.krzysek.skaddon.register.expressions.players;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class InWorld extends SimpleExpression<String> {

    Expression<?> world;

    @Override
    protected String[] get(Event e) {
        String world = (String) this.world.getSingle(e);
        String players = null;
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            if(player.getWorld().getName().equalsIgnoreCase(world)) {
                if(players != null)
                    players = players + player.getName() + ", ";
                else players = player.getName();
                return new String[] { players };
            }
        }
        return null;
    }

    public Class<? extends String> getReturnType() {
        return String.class;
    }

    public boolean isSingle() {
        return true;
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        world = expr[0];
        return true;
    }

}
