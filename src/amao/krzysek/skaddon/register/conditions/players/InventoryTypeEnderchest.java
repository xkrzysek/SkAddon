package amao.krzysek.skaddon.register.conditions.players;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryType;

public class InventoryTypeEnderchest extends Condition {

    Expression<?> player;

    @Override
    public boolean check(Event e) {
        Player p = (Player) player.getSingle(e);
        if(p.getOpenInventory().getType() == InventoryType.ENDER_CHEST)
            return true;
        else return false;
    }

    public String toString(Event e, boolean bool) {
        return getClass().getName();
    }

    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = expr[0];
        return true;
    }

}
