package amao.krzysek.skaddon;

import amao.krzysek.skaddon.register.SkAddon;
import ch.njol.skript.Skript;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SkriptAddon extends JavaPlugin {

    private SkriptAddon instance;

    public SkriptAddon() {
        instance = this;
    }

    @Override
    public void onEnable() {
        if(Bukkit.getPluginManager().getPlugin("Skript") == null)
            Bukkit.getPluginManager().disablePlugin(this);
        else {
            Skript.registerAddon(this);
            SkAddon skaddon = new SkAddon();
            skaddon.register();
        }
    }

    @Override
    public void onDisable() {}

    public SkriptAddon getInstace() {
        if(instance == null)
            return new SkriptAddon();
        else return instance;
    }

}
