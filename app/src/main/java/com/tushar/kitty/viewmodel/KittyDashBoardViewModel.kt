package com.tushar.kitty.viewmodel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tushar.kitty.models.KittyItem
import com.tushar.kitty.repository.KittyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KittyDashBoardViewModel
@Inject constructor(private val repository: KittyRepository):ViewModel(){

  private val _response = MutableLiveData<List<KittyItem>>()
  val response : LiveData<List<KittyItem>>
    get() = _response

  init {
    getAllTvShows()
  }

  private fun getAllTvShows() = viewModelScope.launch {
    repository.getCatList().let {response ->
      if (response.isSuccessful){
        _response.postValue(response.body())
      }else{
        Log.d("cat list fetch failed ",response.code().toString())
      }
    }
  }

}