package amao.krzysek.skaddon.register.expressions.strings;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.util.Random;

public class RandomLetterFromString extends SimpleExpression<String> {

    Expression<?> string;

    @Override
    protected String[] get(Event e) {
        String string = (String) this.string.getSingle(e);
        Random random = new Random();
        return new String[] { String.valueOf(string.charAt(random.nextInt(string.length()+1))).replaceAll(" ", String.valueOf(string.charAt(random.nextInt(string.length()+1)))) };
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
        string = expr[0];
        return true;
    }

}
