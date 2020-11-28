package org.kakara.core.common.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CoreFileUtils {
    public static void backupDeleteAndRecreate(File file) throws IOException {
        backup(file);
        file.delete();
        file.createNewFile();
    }

    public static void backup(File file) throws IOException {
        File backup = new File(file.getAbsolutePath() + ".bak");
        if (backup.exists()) backup.delete();
        Files.copy(file.toPath(), backup.toPath());
    }
}
