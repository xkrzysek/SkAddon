package amao.krzysek.skaddon.register.effects.folders;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;

public class CreateFolder extends Effect {

    Expression<?> path;

    @Override
    protected void execute(Event e) {
        File folder = new File((String) path.getSingle(e));
        if(!(folder.exists()))
            folder.mkdirs();
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        path = expr[0];
        return true;
    }

}
