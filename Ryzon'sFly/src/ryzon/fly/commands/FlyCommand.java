package ryzon.fly.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ryzon.fly.Main;
import ryzon.fly.utils.Utils;

/**
 * created by ryan v on 4/28/2019
 **/
public class FlyCommand implements CommandExecutor {
    private Main plugin;
    public FlyCommand(Main plugin){
        this.plugin = plugin;

        plugin.getCommand("fly").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label1, String[] args){
        if (!(sender instanceof Player)){ //make sure the command executor is an actual player
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_message")));
            return true;
        }

        Player p = (Player) sender;
        if (p.isFlying()){ //bug here, player must actually be in the air for this to trigger, better to do with a bool
            p.setAllowFlight(false);
            p.setFlying(false);
            p.sendMessage(Utils.chat(plugin.getConfig().getString("flying_disabled")));
            return true;
        }
        else {
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage(Utils.chat(plugin.getConfig().getString("flying_enabled")));
            return true;
        }
        //return false;
    }
}
