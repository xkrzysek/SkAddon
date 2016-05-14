package amao.krzysek.skaddon.register.effects.players;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryType;

public class OpenCreative extends Effect {

    Expression<?> player;

    @Override
    protected void execute(Event e) {
        Player name = (Player) player.getSingle(e);
        if(Bukkit.getPlayer(name.getName()) != null)
            name.openInventory(Bukkit.getServer().createInventory(null, InventoryType.CREATIVE));
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = expr[0];
        return true;
    }

}
