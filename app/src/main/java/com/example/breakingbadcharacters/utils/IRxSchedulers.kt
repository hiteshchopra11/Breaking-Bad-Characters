package com.example.breakingbadcharacters.utils

import io.reactivex.rxjava3.core.Scheduler
interface IRxSchedulers {
    fun main(): Scheduler
    fun io(): Scheduler
}