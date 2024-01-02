package com.example.cryproapp.di

import android.app.Application
import com.example.cryproapp.data.database.AppDatabase
import com.example.cryproapp.data.database.CoinInfoDao
import com.example.cryproapp.data.network.ApiFactory
import com.example.cryproapp.data.network.ApiService
import com.example.cryproapp.data.repository.CoinRepositoryImpl
import com.example.cryproapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}