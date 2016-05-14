package amao.krzysek.skaddon.register.expressions.strings;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.util.Random;

public class RandomLetterFromAlphabet extends SimpleExpression<String> {

    String[] letters = {
            "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y",
            "z"
    };

    @Override
    protected String[] get(Event e) {
        Random random = new Random();
        return new String[] { letters[random.nextInt(letters.length)] };
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
