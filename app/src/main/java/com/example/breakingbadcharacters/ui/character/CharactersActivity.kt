package com.example.breakingbadcharacters.ui.character

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.breakingbadcharacters.R
import com.example.breakingbadcharacters.databinding.ActivityCharactersBinding
import com.example.breakingbadcharacters.ui.base.ActivityNavigator
import com.example.breakingbadcharacters.ui.base.BaseActivity
import com.example.breakingbadcharacters.utils.CharactersAdapter
import com.example.breakingbadcharacters.utils.RecycleViewClickListener
import com.example.networkmodule.data.model.Character
import timber.log.Timber

class CharactersActivity : BaseActivity<ActivityCharactersBinding, CharacterViewModel>(),
    RecycleViewClickListener {

    companion object {
        const val CHARACTER_LIST_INTENT = "Character_list_intent"
    }

    private lateinit var charactersAdapter: CharactersAdapter
    override fun getViewModelClass(): Class<CharacterViewModel> = CharacterViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_characters
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val characterList = intent.getParcelableArrayListExtra<Character>(CHARACTER_LIST_INTENT)
        val recycleView = binding.recycleView

        binding.lifecycleOwner = this

        viewModel.getCharactersLiveData(characterList)

        viewModel.character.observe(this, Observer { characters ->
            recycleView.also {
                recycleView.layoutManager = LinearLayoutManager(this)
                charactersAdapter = CharactersAdapter(characters, this)
                recycleView.addItemDecoration(
                    DividerItemDecoration(
                        recycleView.context,
                        (recycleView.layoutManager as LinearLayoutManager).orientation
                    )
                )
                recycleView.adapter = charactersAdapter
            }
        })
        initToolbar()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        ActivityNavigator.finishActivityWithAnimation(
            R.anim.slide_right_in,
            R.anim.slide_right_out,
            this
        )
    }

    override fun onRecyclerViewItemClick(view: View, character: Character) {
        when (view.id) {
            R.id.card_layout -> {
                Timber.d("Clicked on item ${character.name}")
            }
        }
    }
}