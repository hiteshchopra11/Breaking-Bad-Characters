package com.example.breakingbadcharacters.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.breakingbadcharacters.ui.base.BaseViewModel
import com.example.breakingbadcharacters.utils.IRxSchedulers
import com.example.networkmodule.data.model.Character
import com.example.networkmodule.repository.CharacterRepo
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel() {
    @Inject
    lateinit var characterRepo: CharacterRepo

    @Inject
    lateinit var schedulers: IRxSchedulers

    var dataLoading: MutableLiveData<Boolean> = MutableLiveData()
    var dataCharacters: MutableLiveData<ArrayList<Character>> = MutableLiveData()

    fun loadDataRx() {
        dataLoading.value = true
        addDisposable(characterRepo.getCharacters()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .doFinally { dataLoading.value = false }
            .subscribe({ response ->
                dataCharacters.value = response
            }, { Timber.e(it) })
        )
    }
}