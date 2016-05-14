package amao.krzysek.skaddon.register.expressions.strings;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;

public class LastModificationTime extends SimpleExpression<String> {

    Expression<?> path;

    @Override
    protected String[] get(Event e) {
        File fromPath = new File((String) path.getSingle(e));
        return new String[] { fromPath.lastModified() + "" };
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
        path = expr[0];
        return true;
    }

}
