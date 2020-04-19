package fr.oceanwars.soundbroadcast;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor
{
	SoundBroadcast plugin;
	
	public BroadcastCommand(SoundBroadcast plugin_)
	{
		plugin = plugin_;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String written, String[] args)
	{
		if (!sender.hasPermission("soundbroadcast.admin"))
		{
			sender.sendMessage("§cYou are not able to do this!");
			return true;
		}
		else
		{
			plugin.getServer().broadcastMessage(argsToString(args));
			sendSoundToPlayers();
		}
		return true;
	}
	
	private String argsToString(String[] args)
	{
		StringBuilder ret = new StringBuilder("");
		for (String arg : args)
		{
			ret.append(arg.replace('&', '§'));
			ret.append(' ');
		}
		return ret.toString();
	}
	
	private void sendSoundToPlayers()
	{
		String sound = plugin.getConfig().getString("sound");
		float volume = (float)plugin.getConfig().getDouble("volume");
		float pitch = (float)plugin.getConfig().getDouble("pitch");
		for (Player p : Bukkit.getOnlinePlayers())
			p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
	}
}
