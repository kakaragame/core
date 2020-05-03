package org.kakara.core.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CoreFileUtils {
    public static void backupAndDelete(File file) throws IOException {
        File backup = new File(file.getAbsolutePath() + ".bak");
        if (backup.exists()) backup.delete();
        Files.move(file.toPath(), backup.toPath());
    }
}
