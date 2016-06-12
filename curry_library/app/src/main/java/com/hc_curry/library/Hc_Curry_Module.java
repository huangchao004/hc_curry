package com.hc_curry.library;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by huangchao on 6/12/16.
 */
@Module
public class Hc_Curry_Module {


    private final Context mContext;
    public Hc_Curry_Module(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }


    @ActivityScope
    @Component(modules = {Hc_Curry_Module.class})
    public interface Hc_Curry_Componte {
        void injectContext(MainActivity activity);
    }


}
