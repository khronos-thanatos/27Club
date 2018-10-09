package com.a27club.khronos.a27club.entity;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class PlayLists  extends ExpandableGroup<Video> {

    public PlayLists(String title,List<Video> items){
        super(title,items);
    }
}
