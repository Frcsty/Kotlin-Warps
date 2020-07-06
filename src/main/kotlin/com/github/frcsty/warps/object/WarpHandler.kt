package com.github.frcsty.warps.`object`

import org.bukkit.Location
import org.bukkit.entity.Player

class WarpHandler
{
	private val warps = mutableMapOf<String, WarpObject>()
	
	fun addWarp(warp: String, location: Location, player: Player): Boolean
	{
		val existing = this.warps[warp] != null
		
		if (existing)
		{
			return false
		}
		
		val warpObject = WarpObject(location, warp, player)
		this.warps[warp] = warpObject
		return true
	}
	
	fun removeWarp(warp: String): Boolean
	{
		val exists = this.warps[warp] != null
		
		if (exists)
		{
			this.warps.remove(warp)
			return true
		}
		
		return false
	}
	
	fun getWarp(warp: String): WarpObject?
	{
		return this.warps[warp]
	}
	
	fun updateWarp(name: String, warp: WarpObject) {
		this.warps[name] = warp
	}
}