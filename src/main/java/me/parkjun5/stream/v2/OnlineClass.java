package me.parkjun5.stream.v2;

public class OnlineClass {

    private Integer id;
    private String title;
    private boolean closed;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public OnlineClass setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OnlineClass setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isClosed() {
        return closed;
    }

    public OnlineClass setClosed(boolean closed) {
        this.closed = closed;
        return this;
    }

    @Override
    public String toString() {
        return "OnlineClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", closed=" + closed +
                '}';
    }
}
