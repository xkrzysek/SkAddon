package amao.krzysek.skaddon.register.expressions.players;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class Ping extends SimpleExpression<Integer> {

    Expression<?> player;

    @Override
    protected Integer[] get(Event e) {
        Player p = (Player) player.getSingle(e);
        int ping = ((CraftPlayer) p).getHandle().ping;
        return new Integer[] { ping };
    }

    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    public boolean isSingle() {
        return true;
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = expr[0];
        return true;
    }

}
