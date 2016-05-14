package amao.krzysek.skaddon.register.conditions.files;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;

public class FileExists extends Condition {

    Expression<?> path;

    @Override
    public boolean check(Event e) {
        File file = new File((String) path.getSingle(e));
        if(file.exists() && file.isFile())
            return true;
        else return false;
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        path = expr[0];
        return true;
    }

}
