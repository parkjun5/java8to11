package me.parkjun5.optional;

import java.util.Optional;

public class OnlineClassV2 {

    private Integer id;
    private String title;
    private boolean closed;

    public Progress progress;

    public OnlineClassV2(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public OnlineClassV2 setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OnlineClassV2 setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isClosed() {
        return closed;
    }

    public OnlineClassV2 setClosed(boolean closed) {
        this.closed = closed;
        return this;
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "OnlineClassV2{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", closed=" + closed +
                ", progress=" + progress +
                '}';
    }
}
