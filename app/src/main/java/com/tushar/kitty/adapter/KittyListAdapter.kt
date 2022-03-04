package com.tushar.kitty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tushar.kitty.adapter.KittyListAdapter.MyViewHolder
import com.tushar.kitty.databinding.KittyItemBinding
import com.tushar.kitty.models.KittyItem

class KittyListAdapter : RecyclerView.Adapter<MyViewHolder>() {
  inner class MyViewHolder(val binding:KittyItemBinding): RecyclerView.ViewHolder(binding.root)

  private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<KittyItem>() {
    override fun areItemsTheSame(oldItem: KittyItem, newItem: KittyItem): Boolean {
      return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: KittyItem, newItem: KittyItem): Boolean {
      return oldItem == newItem
    }

  })

  var list: List<KittyItem>
    get() = differ.currentList
    set(value) {
      differ.submitList(value)
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    return MyViewHolder(KittyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val current = list[position]
    holder.binding.apply {
      imageView.load(current.url) {
        crossfade(true)
        crossfade(5000)
        //textView.text = current.breeds.toString()
      }
      imageView.setOnClickListener {

      }
    }
  }

  override fun getItemCount(): Int {
    return list.size
  }
}