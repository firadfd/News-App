package fd.firad.theinsider.repository

import fd.firad.theinsider.api.ApiService
import javax.inject.Inject

class NewsRepo @Inject constructor(private val apiService: ApiService) {
    suspend fun getNews() =apiService.getNews("547f8223570f434db2f9fe5753d5d1d6","us");
}