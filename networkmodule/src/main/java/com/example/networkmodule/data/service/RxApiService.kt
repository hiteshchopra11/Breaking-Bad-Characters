package com.example.networkmodule.data.service

import com.example.networkmodule.data.model.Character
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface RxApiService {
    @GET("/api/characters")
    fun getCharacters(): Observable<ArrayList<Character>>
}