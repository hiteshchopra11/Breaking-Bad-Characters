package com.example.breakingbadcharacters.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbadcharacters.injection.scope.ViewModelScope
import com.example.breakingbadcharacters.ui.character.CharacterViewModel
import com.example.breakingbadcharacters.ui.home.HomeViewModel
import com.example.breakingbadcharacters.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelFactoryModule {
    @Binds
    @IntoMap
    @ViewModelScope(CharacterViewModel::class)
    abstract fun bindShowCharacterViewModel(charactersViewModel: CharacterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}