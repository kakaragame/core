package org.kakara.core.server.test.commands;

import org.kakara.core.common.EnvType;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.command.CommandSender;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.gui.Inventory;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.ModCommand;
import org.kakara.core.common.player.Player;
import org.kakara.core.server.ServerGameInstance;
import org.kakara.core.server.gui.ServerInventory;

import java.util.Collections;

public class GiveCommand extends ModCommand {

    public GiveCommand(Mod mod) {
        super(Collections.singleton("give"), "", mod, "give");
    }

    @Override
    public void execute(String command, String[] arguments, String fullCommand, CommandSender executor) {
        if (Kakara.getEnvironmentInstance().getType() == EnvType.SERVER) {
            executor.sendMessage("Must be executed on a server");
            return;
        }
        if(!(executor instanceof Player)){
            executor.sendMessage("Must be executor by a player");
            return;
        }
        if(arguments.length!=1){

            executor.sendMessage("Please use format /give Item{CONTROLLER:KEY}");
            return;
        }
        ServerGameInstance gameInstance = (ServerGameInstance) Kakara.getGameInstance();
        Item item = gameInstance.getItemManager().getItem(arguments[0].toUpperCase());
        if(item==null){
            executor.sendMessage("Not a valid item");
            return;
        }
        Player player = (Player) executor;
        ServerInventory inventory = (ServerInventory) player.getInventory();
        inventory.addItemStack(gameInstance.createItemStack(item));
    }
}
