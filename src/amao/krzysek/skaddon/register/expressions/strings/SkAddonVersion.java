package amao.krzysek.skaddon.register.expressions.strings;

import amao.krzysek.skaddon.register.SkAddon;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public class SkAddonVersion extends SimpleExpression<String> {

    @Override
    protected String[] get(Event e) {
        SkAddon skaddon = new SkAddon();
        return new String[] { skaddon.getVersion() };
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
        return true;
    }

}
