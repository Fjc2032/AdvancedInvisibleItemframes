package me.dasshark.advancedInvisibleItemframes.listeners

import me.dasshark.advancedInvisibleItemframes.Main
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.GlowItemFrame
import org.bukkit.entity.ItemFrame
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.hanging.HangingPlaceEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType


class IFPlaceListener: Listener {

    @EventHandler
    fun onHangingPlace(event: HangingPlaceEvent) {
        if (event.entity.type != EntityType.ITEM_FRAME) return
        val frame: ItemStack
        val player = event.player ?: return

        if (player.inventory.itemInMainHand.type === Material.ITEM_FRAME)
            frame = player.inventory.itemInMainHand
        else if (player.inventory.itemInOffHand.type === Material.ITEM_FRAME)
            frame = player.inventory.itemInOffHand
        else
            return

        if (frame.itemMeta!!.persistentDataContainer.has(Main.invisibleKey, PersistentDataType.BYTE)) {
            val itemFrame: ItemFrame = event.entity as ItemFrame
            itemFrame.isVisible = false
            event.entity.persistentDataContainer.set(Main.invisibleKey, PersistentDataType.BYTE, 1)
        }
    }
    @EventHandler
    fun onGlowHangingPlace(event: HangingPlaceEvent) {
        if (event.entity.type !== EntityType.GLOW_ITEM_FRAME) return
        val glowFrame: ItemStack
        val player = event.player ?: return

        if (player.inventory.itemInMainHand.type === Material.GLOW_ITEM_FRAME)
            glowFrame = player.inventory.itemInMainHand
        else if (player.inventory.itemInOffHand.type === Material.GLOW_ITEM_FRAME)
            glowFrame = player.inventory.itemInOffHand
        else return

        if (glowFrame.itemMeta!!.persistentDataContainer.has(Main.invisibleKey, PersistentDataType.BYTE)) {
            val glowItemFrame: GlowItemFrame = event.entity as GlowItemFrame
            glowItemFrame.isVisible = false
            event.entity.persistentDataContainer.set(Main.invisibleKey, PersistentDataType.BYTE, 1)
        }
    }


}
