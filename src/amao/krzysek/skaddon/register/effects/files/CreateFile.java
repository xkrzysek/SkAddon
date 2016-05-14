package amao.krzysek.skaddon.register.effects.files;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;
import java.io.IOException;

public class CreateFile extends Effect {

    Expression<?> path;

    @Override
    protected void execute(Event e) {
        File file = new File((String) path.getSingle(e));
        if(!(file.exists()))
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        path = expr[0];
        return true;
    }

}
