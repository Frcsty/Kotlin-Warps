package com.github.frcsty.warps.`object`

import org.bukkit.Location
import org.bukkit.entity.Player

data class WarpObject(
		private val location: Location,
		private var name: String,
		val owner: Player)
{
	
	fun teleport(player: Player)
	{
		player.teleport(location)
	}
	
	fun rename(newName: String)
	{
		this.name = newName
	}
	
}