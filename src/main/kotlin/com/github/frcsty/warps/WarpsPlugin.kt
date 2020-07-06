package com.github.frcsty.warps

import com.github.frcsty.warps.`object`.WarpHandler
import com.github.frcsty.warps.command.WarpCommand
import me.mattstudios.mf.base.CommandManager
import org.bukkit.plugin.java.JavaPlugin

class WarpsPlugin : JavaPlugin()
{
	
	private val handler = WarpHandler()
	
	override fun onEnable()
	{
		val manager = CommandManager(this)
		manager.register(WarpCommand(handler))
	}
	
}