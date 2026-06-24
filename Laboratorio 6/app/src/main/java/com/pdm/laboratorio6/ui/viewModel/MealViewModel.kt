package com.pdm.laboratorio6.ui.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm.laboratorio6.data.repository.MealRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.pdm.laboratorio6.data.repository.MealRepositoryImpl
import com.pdm.laboratorio6.data.model.Meal

class MealViewModel(
    private val repository: MealRepository = MealRepositoryImpl()
) : ViewModel() {

    private val _meals = MutableStateFlow<List<Meal>>(emptyList())
    val meals: StateFlow<List<Meal>> = _meals.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    fun loadMeals() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = repository.getMeal()
            result.onSuccess { list ->
                _meals.value = list
                _errorMessage.value = null
            }.onFailure { error ->
                _errorMessage.value = error.message
            }
            _isLoading.value = false
        }
    }
    }

