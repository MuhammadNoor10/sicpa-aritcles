package com.aicpa.articles.dagger.app;

import android.app.Application;

import com.aicpa.articles.app.ArticlesApp;
import com.aicpa.articles.dagger.base.ActivityBuildersModule;
import com.aicpa.articles.dagger.network.ApiModule;
import com.aicpa.articles.dagger.viewmodel.ViewModelFactoryModule;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Noor aka Thor on 2020-04-05.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuildersModule.class,
        ApiModule.class,
        ViewModelFactoryModule.class,
})
public interface AppComponent extends AndroidInjector<ArticlesApp> {
    void inject(ArticlesApp application);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
