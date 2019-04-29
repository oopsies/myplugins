package ryzon.fly;

import org.bukkit.plugin.java.JavaPlugin;
import ryzon.fly.commands.FlyCommand;

/**
 * created by ryan v on 4/28/2019
 **/
public class Main extends JavaPlugin {
    public void onEnable(){//run when plugin starts
        saveDefaultConfig();
        new FlyCommand(this);
        getLogger().info("Ryzon's fly has been enabled.");
    }
}
