package com.example.posty;

import android.media.Image;

public class Post {
    private String username;
    private String displayName;
    private String content;

    public Post(String username, String displayName, String content){
        this.username = username;
        this.displayName = displayName;
        this.content = content;
    }
    public String getUsername(){return username;}
    public String getDisplayName(){return displayName;}
    public String getContent(){return content;}
}
