package com.tushar.kitty

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tushar.kitty.adapter.KittyListAdapter
import com.tushar.kitty.databinding.ActivityMainBinding
import com.tushar.kitty.viewmodel.KittyDashBoardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private val viewModel: KittyDashBoardViewModel by viewModels()
  private lateinit var kittyListAdapter: KittyListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    supportActionBar?.hide()
    setUpRecyclerView()
  }

  private fun setUpRecyclerView() {
    kittyListAdapter = KittyListAdapter()
    binding.recyclerView.apply {
      adapter = kittyListAdapter
      layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
      setHasFixedSize(true)
    }

    viewModel.response.observe(this) { listTvShows ->
      kittyListAdapter.list = listTvShows
    }
  }
}