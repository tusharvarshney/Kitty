package com.tushar.kitty.di

import com.tushar.kitty.api.KittyService
import com.tushar.kitty.helper.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Provides
  fun provideBaseUrl() = Constants.BASE_URL

  @Provides
  @Singleton
  fun provideRetrofitInstance(baseUrl:String):KittyService =
    Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(KittyService::class.java)
}