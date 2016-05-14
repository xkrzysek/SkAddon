package amao.krzysek.skaddon.register.effects.servers;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Shutdown extends Effect {

    Expression<?> message;

    @Override
    protected void execute(Event e) {
        if(message == null)
            Bukkit.getServer().shutdown();
        else {
            String msg = (String) message.getSingle(e);
            for(int i = 0;i != 10;i++)
                Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            BukkitTask task = new BukkitRunnable() {
                public void run() {
                        Bukkit.getServer().shutdown();
                    }
            }.runTaskLater(Bukkit.getPluginManager().getPlugin("SkAddon"), 200L);
        }
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        message = expr[0];
        return true;
    }

}
