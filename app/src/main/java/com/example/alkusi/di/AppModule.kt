package com.example.alkusi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
//    @Provides
//    @Singleton
}
//@Module
//@InstallIn(SingletonComponent::class)
//class AppModule {
//    @Provides
//    @Singleton
//    fun provideStockApi():StockApi
//    {
//        return Retrofit.Builder().baseUrl(StockApi.BASE_URL).addConverterFactory(MoshiConverterFactory.create()).build().create()
//    }
//    @Provides
//    @Singleton
//    fun provideStockDatabase(app: Application):StockDatabase
//    {
//        return Room.databaseBuilder(app,StockDatabase::class.java,"stockdb.db").build()
//    }
//
//}