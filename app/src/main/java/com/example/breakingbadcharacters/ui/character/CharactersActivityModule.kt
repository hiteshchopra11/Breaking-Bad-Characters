package com.example.breakingbadcharacters.ui.character

import android.content.Context
import com.example.breakingbadcharacters.injection.module.BaseActivityModule
import com.example.breakingbadcharacters.injection.qualifiers.ActivityContext
import com.example.breakingbadcharacters.injection.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class CharactersActivityModule {

    @Binds
    @ActivityContext
    abstract fun provideActivityContext(activity: CharactersActivity): Context

    @Binds
    @ActivityScope
    abstract fun provideActivity(showCharactersActivity: CharactersActivity): DaggerAppCompatActivity
}