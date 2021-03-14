package com.example.breakingbadcharacters.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.breakingbadcharacters.ui.base.BaseViewModel
import com.example.networkmodule.data.model.Character
import javax.inject.Inject

class CharacterViewModel @Inject constructor() : BaseViewModel() {

    private val _characterLiveData = MutableLiveData<ArrayList<Character>>()

    val character: LiveData<ArrayList<Character>>
        get() = _characterLiveData

    fun getCharactersLiveData(characterList: java.util.ArrayList<Character>?) {
        _characterLiveData.value = characterList
    }

}