package com.example.cryproapp.data.network

import com.example.cryproapp.data.network.model.CoinInfoJsonContainerDto
import com.example.cryproapp.data.network.model.CoinNamesListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    suspend fun getTopCoinsInfo(
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
    ): CoinNamesListDto

    @GET("pricemultifull")
    suspend fun getFullPriceList(
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
    ): CoinInfoJsonContainerDto

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
        private const val CURRENCY = "USD"
        private const val API_KEY = "4c38ac0cffdda8c60c85db860b1b727c7b8c0067484dace7edd119aae69651e0"
    }
}