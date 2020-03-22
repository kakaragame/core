package org.kakara.core.mod.game;

import org.kakara.core.NameKey;
import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.key.KeyBindHandler;
import org.kakara.core.mod.Mod;

public abstract class ModKeyBindHandler implements KeyBindHandler {
    private Mod mod;
    private NameKey nameKey;

    public ModKeyBindHandler(Mod mod) {
        this.mod = mod;
        this.nameKey = new NameKey(mod, getID());
    }

    @Override
    public NameKey getNameKey() {
        return nameKey;
    }

    @Override
    public String getName() {
        Name name = getClass().getAnnotation(Name.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }

    public String getID() {
        Id name = getClass().getAnnotation(Id.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }


}
