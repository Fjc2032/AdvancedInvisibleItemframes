package me.dasshark.advancedInvisibleItemframes.listeners

import me.dasshark.advancedInvisibleItemframes.Main
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.hanging.HangingBreakEvent
import org.bukkit.persistence.PersistentDataType


class IFBreakListener : Listener {

    @EventHandler
     fun onHangingBreak(event: HangingBreakEvent) {
         if (event.entity.persistentDataContainer.has(Main.invisibleKey, PersistentDataType.BYTE)) {
             event.isCancelled = true
             if (event.entity.type == EntityType.ITEM_FRAME) {
                 event.entity.remove()
                 event.entity.world.dropItemNaturally(event.entity.location, Main.instance.getInvisFrame(false)!!)
             }
             else if (event.entity.type == EntityType.GLOW_ITEM_FRAME) {
                 event.entity.remove()
                 event.entity.world.dropItemNaturally(event.entity.location, Main.instance.getGlowInvisFrame(false)!!)
             }
         }
     }

}
