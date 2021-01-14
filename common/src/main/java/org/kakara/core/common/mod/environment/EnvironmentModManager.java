package org.kakara.core.common.mod.environment;

import me.kingtux.other.TheCodeOfAMadMan;
import me.kingtux.simpleannotation.MethodFinder;
import org.apache.commons.lang3.StringUtils;
import org.kakara.core.common.EnvTypeable;
import org.kakara.core.common.EnvironmentInstance;
import org.kakara.core.common.GameInstance;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.annotations.Environment;
import org.kakara.core.common.exceptions.IllegalModException;
import org.kakara.core.common.mod.*;
import org.kakara.core.common.mod.annotations.LoadingStage;
import org.kakara.core.common.mod.game.GameModLoader;
import org.kakara.core.common.resources.ResourceType;
import org.kakara.core.common.resources.TextureResolution;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class EnvironmentModManager extends AbstractModManager {

    public EnvironmentModManager(Mod coreMod) {
        super(coreMod);
    }
    @Override
    public void load(EnvTypeable typeable) {
        super.load(typeable);
        modLoader = new GameModLoader();
    }
}
