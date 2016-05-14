package amao.krzysek.skaddon.register.expressions.players;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class Yaw extends SimpleExpression<Float> {

    Expression<?> player;

    @Override
    protected Float[] get(Event e) {
        Player p = (Player) player.getSingle(e);
        float yaw = p.getEyeLocation().getYaw();
        return new Float[] { yaw };
    }

    public Class<? extends Float> getReturnType() {
        return Float.class;
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
