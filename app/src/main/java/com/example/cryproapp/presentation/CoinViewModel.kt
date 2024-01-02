package com.example.cryproapp.presentation

import androidx.lifecycle.ViewModel
import com.example.cryproapp.domain.GetCoinInfoListUseCase
import com.example.cryproapp.domain.GetCoinInfoUseCase
import com.example.cryproapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase,
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)


    init {
        loadDataUseCase()
    }

}