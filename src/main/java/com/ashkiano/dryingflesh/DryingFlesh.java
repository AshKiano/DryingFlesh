package com.ashkiano.dryingflesh;

import org.bukkit.plugin.java.JavaPlugin;

//TODO opravit, že se tam vloží i když to schnilé maso odebere a nahradí
//TODO přidat permise
//TODO konfigurovatelnost
public class DryingFlesh extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ItemFrameListener(this), this);
        Metrics metrics = new Metrics(this, 22163);
        this.getLogger().info("Thank you for using the DryingFlesh plugin! If you enjoy using this plugin, please consider making a donation to support the development. You can donate at: https://donate.ashkiano.com");
    }

    @Override
    public void onDisable() {
        getLogger().info("DryingFlesh plugin has been disabled.");
    }
}
