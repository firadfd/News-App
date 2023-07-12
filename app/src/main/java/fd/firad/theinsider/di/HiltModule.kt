package fd.firad.theinsider.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fd.firad.theinsider.api.ApiService
import fd.firad.theinsider.util.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideBaseUrl() = Util.BASE_URL

    @Provides
    @Singleton
    fun getRetrofit(BASE_URL: String): ApiService = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}