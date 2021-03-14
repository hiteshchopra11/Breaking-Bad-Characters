package com.example.breakingbadcharacters.injection.module

import com.example.breakingbadcharacters.injection.scope.ActivityScope
import com.example.breakingbadcharacters.ui.character.CharactersActivity
import com.example.breakingbadcharacters.ui.character.CharactersActivityModule
import com.example.breakingbadcharacters.ui.home.HomeActivity
import com.example.breakingbadcharacters.ui.home.HomeActivityModule
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [CharactersActivityModule::class]
    )
    internal abstract fun bindCharacterActivity(): CharactersActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    internal abstract fun bindHomeActivity(): HomeActivity

}

@Module(includes = [BaseActivityModule::class])
abstract class ActivityModule<in T : DaggerAppCompatActivity> {
    @Binds
    @ActivityScope
    internal abstract fun bindActivity(activity: T): DaggerAppCompatActivity
}

/**
 * Activity specific common dependencies should be placed here
 */
@Module
open class BaseActivityModule {
    @ActivityScope
    @Provides
    internal fun provideRxPermissions(activity: DaggerAppCompatActivity) = RxPermissions(
        activity
    )
}