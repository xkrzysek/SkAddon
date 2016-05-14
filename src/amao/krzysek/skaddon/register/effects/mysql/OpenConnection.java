package amao.krzysek.skaddon.register.effects.mysql;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.sql.SQLException;

public class OpenConnection extends Effect {

    Expression<?> host;
    Expression<?> port;
    Expression<?> database;
    Expression<?> user;
    Expression<?> password;

    @Override
    protected void execute(Event e) {
        String host = (String) this.host.getSingle(e);
        String port = (String) this.port.getSingle(e);
        String database = (String) this.database.getSingle(e);
        String user = (String) this.user.getSingle(e);
        String password = (String) this.password.getSingle(e);
        try {
            MySQLManager mysqlmanager = new MySQLManager(host, port, database, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex2) {
            ex2.printStackTrace();
        }
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        host = expr[0];
        port = expr[1];
        database = expr[2];
        user = expr[3];
        password = expr[4];
        return true;
    }

}
