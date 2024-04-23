package com.example.alkusi.di

import android.app.Application
import androidx.room.Room
import com.example.alkusi.BuildConfig
import com.example.alkusi.data.local.AlkusiDb
import com.example.alkusi.data.remote.AlkusiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAlkusiApi(): AlkusiApi {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(AlkusiApi::class.java)
    }

    @Provides
    @Singleton
    fun getAlkusiDb(app: Application): AlkusiDb {
        return Room.databaseBuilder(app, AlkusiDb::class.java, "alkusi.db").build()
    }
}
