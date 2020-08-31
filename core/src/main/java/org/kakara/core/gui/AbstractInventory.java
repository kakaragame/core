package org.kakara.core.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.game.ItemStack;

import java.util.Iterator;
import java.util.List;

public abstract class AbstractInventory implements Inventory {
    protected final List<ItemStack> contents;
    private final int capacity;

    public AbstractInventory(int capacity) {
        contents = InventoryUtils.listWithAir(capacity);
        this.capacity = capacity;
    }

    @Override
    public void addItemStack(@NotNull ItemStack itemStack) {
        for (int i = 0; i < contents.size(); i++) {
            if (contents.get(i).equalsIgnoreCount(itemStack)) {
                contents.get(i).setCount(contents.get(i).getCount() + itemStack.getCount());
            } else if (contents.get(i).getItem().getId() == 0) {
                contents.set(i, itemStack);
                return;
            }
        }
        redraw();
    }

    @Override
    public void clear() {
        contents.clear();
    }

    @Override
    public @NotNull ItemStack getItemStack(int index) {
        if (index > capacity) {
            throw new IndexOutOfBoundsException("Max capacity of Inventory is " + capacity);
        }
        return contents.get(index);
    }

    @Override
    public int getSize() {
        return contents.size();
    }

    @Override
    public @NotNull ItemStack[] getContents() {
        return contents.toArray(ItemStack[]::new);
    }

    @Override
    public void setItemStack(@NotNull ItemStack itemStack, int index) {
        contents.set(index, itemStack);
    }

    @NotNull
    @Override
    public Iterator<ItemStack> iterator() {
        return contents.iterator();
    }
}
