package org.kakara.core.mod.game;

import org.kakara.core.ControllerKey;
import org.kakara.core.annotations.Key;
import org.kakara.core.annotations.Name;
import org.kakara.core.key.KeyBindHandler;
import org.kakara.core.mod.Mod;

public abstract class ModKeyBindHandler implements KeyBindHandler {
    private final Mod mod;
    private final ControllerKey nameKey;

    public ModKeyBindHandler(Mod mod) {
        this.mod = mod;
        this.nameKey = new ControllerKey(mod, getID());
    }

    @Override
    public ControllerKey getNameKey() {
        return nameKey;
    }

    @Override
    public String getName() {
        Name name = getClass().getAnnotation(Name.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }

    public String getID() {
        Key name = getClass().getAnnotation(Key.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }


}
