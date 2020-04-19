package fr.oceanwars.soundbroadcast;

import org.bukkit.plugin.java.JavaPlugin;

public class SoundBroadcast extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		saveDefaultConfig();
		// Register command
		getCommand("soundbroadcast").setExecutor(new BroadcastCommand(this));
	}
	
	@Override
	public void onDisable()
	{
	}
}
