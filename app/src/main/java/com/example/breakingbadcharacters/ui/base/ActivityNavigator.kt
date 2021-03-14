package com.example.breakingbadcharacters.ui.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

object ActivityNavigator {
    fun startActivityWithDataAndAnimation(
        activityClass: Class<out Activity>,
        bundle: Bundle,
        inAnimation: Int,
        outAnimation: Int,
        activity: AppCompatActivity
    ) {
        val intent = Intent(activity, activityClass)
        intent.putExtras(bundle)
        activity.startActivity(intent)
        activity.overridePendingTransition(inAnimation, outAnimation)
    }

    fun finishActivityWithAnimation(
        inAnimation: Int,
        outAnimation: Int,
        activity: AppCompatActivity
    ) {
        activity.finish()
        activity.overridePendingTransition(inAnimation, outAnimation)
    }

}