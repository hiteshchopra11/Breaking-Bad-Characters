package com.example.breakingbadcharacters.ui.home

import android.content.Context
import com.example.breakingbadcharacters.injection.module.BaseActivityModule
import com.example.breakingbadcharacters.injection.qualifiers.ActivityContext
import com.example.breakingbadcharacters.injection.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class HomeActivityModule {

    @Binds
    @ActivityContext
    abstract fun provideActivityContext(activity: HomeActivity): Context

    @Binds
    @ActivityScope
    abstract fun provideActivity(homeActivity: HomeActivity): DaggerAppCompatActivity
}