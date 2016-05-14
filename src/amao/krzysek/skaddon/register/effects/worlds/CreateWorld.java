package amao.krzysek.skaddon.register.effects.worlds;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.event.Event;

public class CreateWorld extends Effect {

    Expression<?> name;
    @Override
    protected void execute(Event e) {
        String name = (String) this.name.getSingle(e);
        WorldCreator world = new WorldCreator(name);
        Bukkit.getServer().createWorld(world);
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        name = expr[0];
        return true;
    }

}
