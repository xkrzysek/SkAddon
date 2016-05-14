package amao.krzysek.skaddon.register.expressions.strings;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;

public class DisabledScripts extends SimpleExpression<String> {

    @Override
    protected String[] get(Event e) {
        File file = new File("plugins/Skript/scripts");
        File[] files = file.listFiles();
        String fls = null;
        for(int i = 0;i < files.length;i++) {
            if(files[i].isFile()) {
                if(files[i].getName().contains("-")) {
                    if(fls != null)
                        fls = fls + ", " + files[i].getName();
                    else fls = files[i].getName();
                    return new String[] { fls };
                }
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
        return true;
    }

}
