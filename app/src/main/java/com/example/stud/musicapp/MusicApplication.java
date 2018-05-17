package com.example.stud.musicapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by W57448 on 2018-05-17.
 */

public class MusicApplication extends Application {
    @Override
    public void onCreate() {
        super .onCreate();

        Realm. init ( this );
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion( 1 )
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm. compactRealm (realmConfiguration);
        Realm. setDefaultConfiguration (realmConfiguration);
    }
}
