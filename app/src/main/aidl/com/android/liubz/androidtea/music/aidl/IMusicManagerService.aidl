// IMusicManagerService.aidl
package com.android.liubz.androidtea.music.aidl;

// Declare any non-default types here with import statements
import com.android.liubz.androidtea.music.aidl.Song;

interface IMusicManagerService {
    void showSong(in Song song);
    void startPlay();
    void stopPlay();
    void next();
    void previous();
    int getCurProgress();
}
