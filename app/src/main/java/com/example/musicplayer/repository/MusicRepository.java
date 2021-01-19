package com.example.musicplayer.repository;

import android.content.Context;

public class MusicRepository {
    private static MusicRepository sInstance;
    private Context mContext;

    public static MusicRepository getInstance(Context context) {
        if (sInstance==null)
            sInstance=new MusicRepository(context);
        return sInstance;
    }

    public MusicRepository(Context context) {
        mContext = context.getApplicationContext();
    }
}
