package org.kakara.core.player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class Toast {
    @NotNull
    private final String title;
    @NotNull
    private final String content;
    @Nullable
    private final Color color;

    public Toast(@NotNull String title, @NotNull String content, @NotNull Color color) {
        this.title = title;
        this.content = content;
        this.color = color;
    }

    public Toast(@NotNull String title, @NotNull String content) {
        this.title = title;
        this.content = content;
        this.color = null;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public String getContent() {
        return content;
    }

    @Nullable
    public Color getColor() {
        return color;
    }
}
