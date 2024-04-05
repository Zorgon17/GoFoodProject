package com.example.go.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.go.network.AppApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


/** Возможные состояния пользовательского интерфейса */
sealed interface AppUiState {
    data class Success(val categories: String) : AppUiState
    data object Error : AppUiState
    data object Loading : AppUiState
}

class AppViewModel(): ViewModel() {

    /** Добавляем состояние пользовательского интерфейса */
    var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    init {
        getCategoriesValue()
    }

    /** viewModelScope снимает любую сопраграмму если ViewModel снят с использования */
    /** блоком try/catch обрабатываем ошибку невозможности загрузки данных */
    fun getCategoriesValue() {
        viewModelScope.launch {
            appUiState = AppUiState.Loading
            appUiState = try {
                val categoriesList = AppApi.retrofitService.getCategories()
                AppUiState.Success("Yeah $categoriesList")
            } catch (e: IOException) {
                AppUiState.Error
            } catch (e: HttpException) {
                AppUiState.Error
            }
        }
    }
}

