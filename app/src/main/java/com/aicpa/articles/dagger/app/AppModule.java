package com.aicpa.articles.dagger.app;

import android.app.Application;
import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Noor aka Thor on 2020-04-05.
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    public Context provideAppContext(Application application) {
        return application.getApplicationContext();
    }
}
