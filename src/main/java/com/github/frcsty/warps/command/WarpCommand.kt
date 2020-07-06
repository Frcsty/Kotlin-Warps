package com.github.frcsty.warps.command

import com.github.frcsty.warps.`object`.WarpHandler
import me.mattstudios.mf.annotations.Command
import me.mattstudios.mf.annotations.Default
import me.mattstudios.mf.annotations.SubCommand
import me.mattstudios.mf.base.CommandBase
import org.bukkit.entity.Player

@Command("warp")
class WarpCommand(
		private val handler: WarpHandler
                 ) : CommandBase()
{
	
	@Default
	fun warpCommand(player: Player, warp: String)
	{
		val warpObject = handler.getWarp(warp)
		
		if (warp == "create" || warp == "remove" || warp == "rename")
		{
			player.sendMessage("Those are not valid warps, and should be used as commands.")
			return
		}
		
		if (warpObject == null)
		{
			player.sendMessage("The specified warp does not exist!")
			return
		}
		
		warpObject.teleport(player)
	}
	
	@SubCommand("create")
	fun warpCreateCommand(player: Player, warp: String)
	{
		if (handler.addWarp(warp, player.location, player))
		{
			player.sendMessage("You have successfully created a warp!")
			return
		}
		
		player.sendMessage("Failed to create a warp, as a equally named one already exists!")
	}
	
	@SubCommand("remove")
	fun warpRemoveCommand(player: Player, warp: String)
	{
		val warpObject = handler.getWarp(warp)
		
		if (warpObject == null)
		{
			player.sendMessage("The specified warp does not exist!")
			return
		}
		
		if (warpObject.owner == player)
		{
			player.sendMessage("Could not remove the specified warp, as you do not own it!")
			return
		}
		
		if (handler.removeWarp(warp))
		{
			player.sendMessage("You have successfully removed your warp!")
		}
	}
	
	@SubCommand("rename")
	fun warpRenameCommand(player: Player, warp: String, name: String)
	{
		val warpObject = handler.getWarp(warp)
		
		if (warpObject == null) {
			player.sendMessage("The specified warp does not exist!")
			return
		}
		
		warpObject.rename(name)
		handler.updateWarp(warp, warpObject)
	}
	
}