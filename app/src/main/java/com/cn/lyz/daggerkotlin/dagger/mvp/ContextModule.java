package com.cn.lyz.daggerkotlin.dagger.mvp;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yunzhao.liu on 2018/3/7
 */
@Module
public class ContextModule {

    Context mContext;

    public ContextModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mContext;
    }
}
