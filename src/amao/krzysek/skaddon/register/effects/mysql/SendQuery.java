package amao.krzysek.skaddon.register.effects.mysql;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.sql.SQLException;

public class SendQuery extends Effect {

    Expression<?> query;

    @Override
    protected void execute(Event e) {
        MySQLManager mysqlmanager = new MySQLManager();
        try {
            mysqlmanager.sendQuery((String) query.getSingle(e));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        query = expr[0];
        return true;
    }

}
