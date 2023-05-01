package fd.firad.theinsider.api

import fd.firad.theinsider.model.NewsMainResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("apiKey") apikey: String,
        @Query("country") country : String,
    ): Response<NewsMainResponse>
}