package fd.firad.theinsider.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fd.firad.theinsider.model.ApiResponse
import fd.firad.theinsider.repository.NewsRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject constructor(private val newsRepo: NewsRepo) : ViewModel() {
    private val _response = MutableLiveData<ApiResponse>()

    val response: LiveData<ApiResponse>
        get() = _response


    init {

        viewModelScope.launch {
            newsRepo.getNews().let { result ->
                _response.postValue(ApiResponse.Loading)

                if (result.isSuccessful) {
                    _response.postValue((ApiResponse.Success(result.body()!!)))
                } else {
                    _response.value = (ApiResponse.Error(result.errorBody().toString()))
                }
            }
        }
    }
}