package com.example.go.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.go.model.Categories
import com.example.go.model.Meals
import com.example.go.network.AppApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


/** Возможные состояния пользовательского интерфейса */
sealed interface AppUiState {
    data class Success(
        val categories: Categories,
        val meals: Meals,
        val nameOfCategory: String = ""
    ) : AppUiState

    data object Error : AppUiState
    data object Loading : AppUiState
}

class AppViewModel : ViewModel() {

    /** Добавляем состояние пользовательского интерфейса */
    var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    init {
        getValue()
    }

    /** viewModelScope снимает любую сопраграмму если ViewModel снят с использования */
    /** блоком try/catch обрабатываем ошибку невозможности загрузки данных */
    fun getValue() {
        viewModelScope.launch {
            appUiState = AppUiState.Loading
            appUiState = try {
                val categoriesList = AppApi.retrofitService.getCategories()
                val mealsList = AppApi.retrofitService.getMeals()
                AppUiState.Success(categoriesList, mealsList)
            } catch (e: IOException) {
                AppUiState.Error
            } catch (e: HttpException) {
                AppUiState.Error
            }
        }
    }
}

