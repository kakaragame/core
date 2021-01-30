package org.kakara.core;

import java.io.IOException;

public class Version {
    public static String CORE_VERSION = "1.0-SNAPSHOT";

    /**
     * Generates the Core version based on the current branch.
     * Ignores for non snapshots.
     * Ignores for master branch
     *
     * @return the core version.
     */
    public static String getCoreVersion() {
        String value = CORE_VERSION;
        if (CORE_VERSION.endsWith("-SNAPSHOT")) {
            try {
                String branch = execCmd("git rev-parse --abbrev-ref HEAD").replace("\n", "");
                if (!branch.equalsIgnoreCase("master")) {
                    value = CORE_VERSION.replace("-SNAPSHOT", String.format("-%s-SNAPSHOT", branch.replace("/", "-")));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Building with version: " + value);
        return value;
    }

    public static String execCmd(String cmd) throws IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
