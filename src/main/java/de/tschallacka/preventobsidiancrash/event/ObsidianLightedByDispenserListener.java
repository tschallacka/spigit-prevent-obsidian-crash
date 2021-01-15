package de.tschallacka.preventobsidiancrash.event;

import de.tschallacka.preventobsidiancrash.PreventObsidianCrash;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

public class ObsidianLightedByDispenserListener implements Listener
{
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent event) {
        Block block = event.getBlock();
        ItemStack item =  event.getItem();
        if(item.getType() == Material.FLINT_AND_STEEL) {
            Location loc = block.getLocation();
            if(block.getBlockData() instanceof Directional) {
                if(((Directional)block.getBlockData()).getFacing() == BlockFace.DOWN) {
                    Location down = loc.clone().add(0, -1, 0);
                    World world = block.getWorld();
                    Block air = world.getBlockAt(down);
                    Block air2 = world.getBlockAt(down.clone().add(0, -1, 0));
                    if(air.getType() == Material.AIR && air2.getType() == Material.AIR) {
                        Location west = down.clone().add(-1,0,0);
                        Location east = down.clone().add(1,0,0);
                        Location north = down.clone().add(0,0,-1);
                        Location south = down.clone().add(0,0,1);
                        if(
                                isObsidian(west, world) ||
                                isObsidian(east, world) ||
                                isObsidian(north, world) ||
                                isObsidian(south, world)
                        ) {
                            event.setCancelled(true);
                        }
                    }
                }
            }

        }
    }

    public boolean isObsidian(Location loc, World world)
    {
        return world.getBlockAt(loc).getType() == Material.OBSIDIAN;
    }
}
