package com.example.musicplayer.model;

public class MusicModel {
    private String mMusicName;
    private String mAddressPath;
    private String mSignerName;
    private String mImagePath;


    public MusicModel(String addressPath) {
        mAddressPath = addressPath;

    }

    public MusicModel() {
    }

    public String getSignerName() {
        return mSignerName;
    }

    public void setSignerName(String signerName) {
        mSignerName = signerName;
    }

    public String getImagePath() {
        return mImagePath;
    }

    public void setImagePath(String imagePath) {
        mImagePath = imagePath;
    }

    public String getMusicName() {
        return mMusicName;
    }

    public void setMusicName(String musicName) {
        mMusicName = musicName;
    }

    public String getAddressPath() {
        return mAddressPath;
    }

    public void setAddressPath(String addressPath) {
        mAddressPath = addressPath;
    }
}
