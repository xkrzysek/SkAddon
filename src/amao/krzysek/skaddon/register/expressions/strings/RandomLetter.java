package amao.krzysek.skaddon.register.expressions.strings;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.util.*;

public class RandomLetter extends SimpleExpression<String> {

    Expression<?> a;
    Expression<?> b;

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
        String a = (String) this.a.getSingle(e);
        String b = (String) this.b.getSingle(e);
        if(a != null) {
            if(b != null) {
                int first = 0;
                int second = 0;
                for(int i = 0;i != letters.length;i++) {
                    if(letters[i].matches(a)) {
                        if(first == 0)
                            first = i;
                    }
                    if(letters[i].matches(b)) {
                        if(second == 0)
                            second = i;
                    }
                }
                Random random = new Random();
                return new String[] { letters[random.nextInt((second-first)+1)] };
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
        a = expr[0];
        b = expr[1];
        return true;
    }

}
