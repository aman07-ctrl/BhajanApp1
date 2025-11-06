package com.examplespringboot.demo;

public class Bhajan {
    private String title;
    private String youtubeUrl;
    private String god;

    public Bhajan(String title, String youtubeUrl, String god) {
        this.title = title;
        this.youtubeUrl = youtubeUrl;
        this.god = god;
    }

    public String getTitle() {
        return title;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public String getGod() {
        return god;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public void setGod(String god) {
        this.god = god;
    }
}

