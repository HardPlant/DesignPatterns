package com.designpattern.proxy;

public interface PersonBean{
    String getName();
    String getGender();
    String getInterests();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String Gender);
    void setInterests(String interest);
    void setHotOrNotRating(int rating);
}