package com.ashkiano.dryingflesh;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public class ItemFrameListener implements Listener {
    private final JavaPlugin plugin;

    public ItemFrameListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof ItemFrame) {
            Player player = event.getPlayer();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            ItemFrame itemFrame = (ItemFrame) event.getRightClicked();

            if (itemInHand != null && itemInHand.getType() == Material.ROTTEN_FLESH) {
                //player.sendMessage("Shnilé maso bylo vloženo do item frame. Sušení začíná...");

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (itemFrame.getItem() != null && itemFrame.getItem().getType() == Material.ROTTEN_FLESH) {
                            itemFrame.setItem(new ItemStack(Material.COOKED_BEEF));
                            //player.sendMessage("Shnilé maso bylo usušeno a přeměněno na vařené maso!");
                        }
                    }
                }.runTaskLater(plugin, 20 * 60 * 5); // 5 minut
            }
        }
    }
}