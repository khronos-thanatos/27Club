package com.a27club.khronos.a27club.entity;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayListResponse {

    @SerializedName("Playlists") private List<PlayLists> playlistsList;

    public List<PlayLists> getPlayList(){
        return playlistsList;
    }
}
