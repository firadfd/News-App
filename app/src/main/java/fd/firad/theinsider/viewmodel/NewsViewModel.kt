package fd.firad.theinsider.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fd.firad.theinsider.model.NewsMainResponse
import fd.firad.theinsider.repository.NewsRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject constructor(private val newsRepo: NewsRepo) : ViewModel() {
    private val _response = MutableLiveData<NewsMainResponse>()

    val response: LiveData<NewsMainResponse>
        get() = _response

    init {

        viewModelScope.launch {
            newsRepo.getNews().let { result ->
                if (result.isSuccessful) {
                    _response.postValue(result.body())
                } else {
                    Log.d("TAG", "getAllData: ${result.code()}")
                }
            }
        }
    }
}