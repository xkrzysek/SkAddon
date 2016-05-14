package amao.krzysek.skaddon.register.expressions.strings;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlContent extends SimpleExpression<String> {

    Expression<?> url;

    @Override
    protected String[] get(Event e) {
        String url = (String) this.url.getSingle(e);
        String ls = null;
        try {
            URL address = new URL(url);
            URLConnection connection = address.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null)
                if(ls != null)
                    ls = ls + "\n" + inputLine;
                else ls = inputLine;
            in.close();
            return new String[] { ls };
        } catch (Exception ex) {
            ex.printStackTrace();
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
        url = expr[0];
        return true;
    }

}
