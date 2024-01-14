package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.data.api.TMDP
import com.example.newsfilm.data.api.TMDPUpcoming
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl).build()

    }

    @Singleton
    @Provides
    fun providerTMDPService(retrofit: Retrofit): TMDP {

        return retrofit.create(TMDP::class.java)
    }

    @Singleton
    @Provides
    fun providerTMDPService2(retrofit: Retrofit): TMDPUpcoming {

        return retrofit.create(TMDPUpcoming::class.java)
    }
}