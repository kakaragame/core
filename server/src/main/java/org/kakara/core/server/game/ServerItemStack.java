package org.kakara.core.server.game;

import org.kakara.core.common.game.ItemStack;

import java.util.List;

public interface ServerItemStack extends ItemStack {


    void setCount(int count);


    void setName(String name);


    void setLore(List<String> lore);

    ItemStack clone();

}
