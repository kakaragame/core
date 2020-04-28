package org.kakara.core.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CoreFileUtils {
    public static void backupAndDelete(File file) throws IOException {
        String backup = file.getAbsolutePath() + ".bak";
        Files.move(file.toPath(), new File(backup).toPath());
    }
}
