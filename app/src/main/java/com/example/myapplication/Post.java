package com.example.myapplication;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.sql.Timestamp;
import java.util.Date;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String KEY_DESCRIPTION ="description";
    public static final String KEY_IMAGE="image";
    public static final String KEY_IMAGE2="profile";
    public static final String KEY_USER ="user";
    public static final String KEY_CREATED_KEY ="createdAt";

    public String getdescription(){
        return getString(KEY_DESCRIPTION);
    }
public void setdescription(String description) {
        put(KEY_DESCRIPTION,description);
}


public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
}
    public ParseFile getImage2(){
        return getParseFile(KEY_IMAGE2);
    }

public void setImage (ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
}
public void setImage2 (ParseFile parseFile){
        put(KEY_IMAGE2, parseFile);
    }

public ParseUser getUser(){
        return getParseUser(KEY_USER);
}
public void setUser(ParseUser user){
      put(KEY_USER,user)  ;
}
}
