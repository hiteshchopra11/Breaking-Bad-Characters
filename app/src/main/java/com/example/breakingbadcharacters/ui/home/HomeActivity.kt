package com.example.breakingbadcharacters.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.breakingbadcharacters.R
import com.example.breakingbadcharacters.databinding.ActivityMainBinding
import com.example.breakingbadcharacters.ui.base.ActivityNavigator
import com.example.breakingbadcharacters.ui.base.BaseActivity
import com.example.breakingbadcharacters.ui.character.CharactersActivity

class HomeActivity : BaseActivity<ActivityMainBinding, HomeViewModel>() {
    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun layoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.fetchDataButton.setOnClickListener { viewModel.loadDataRx() }

        viewModel.dataLoading.observe(this, Observer { handleDataLoadingUi(it!!) })

        viewModel.dataCharacters.observe(this, Observer {
            val bundle = Bundle()
            bundle.putParcelableArrayList(CharactersActivity.CHARACTER_LIST_INTENT, it)
            charactersActivity(bundle)
        })
    }

    private fun charactersActivity(bundle: Bundle) {
        ActivityNavigator.startActivityWithDataAndAnimation(
            CharactersActivity::class.java,
            bundle,
            R.anim.slide_left_in,
            R.anim.slide_left_out,
            this
        )
    }


    private fun handleDataLoadingUi(loading: Boolean) {
        binding.progressbar.visibility = if (loading) View.VISIBLE else View.INVISIBLE
        binding.fetchDataButton.isEnabled = !loading
    }
}