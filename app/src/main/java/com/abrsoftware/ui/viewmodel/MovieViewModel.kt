package com.abrsoftware.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abrsoftware.data.model.MovieModel
import com.abrsoftware.domain.GetMoviesUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private var getMovieUseCase: GetMoviesUserCase
) :ViewModel(){
    val movieModel = MutableLiveData<MovieModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMovieUseCase()

            if(!result.isNullOrEmpty()){
                movieModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
}