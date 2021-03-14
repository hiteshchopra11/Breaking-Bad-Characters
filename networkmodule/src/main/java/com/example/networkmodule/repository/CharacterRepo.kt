package com.example.networkmodule.repository

import com.example.networkmodule.data.service.RxApiService
import io.reactivex.rxjava3.core.Observable
import com.example.networkmodule.data.model.Character

import javax.inject.Inject

class CharacterRepo @Inject constructor(private val rxApiService: RxApiService) {
    fun getCharacters(): Observable<ArrayList<Character>> {
        return rxApiService.getCharacters()
    }
}