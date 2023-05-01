package com.example.spaceapp.ui.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceapp.domain.Repository
import com.example.spaceapp.domain.models.DayPictureData
import kotlinx.coroutines.launch
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _dayPictureLiveData = MutableLiveData<DayPictureData>()
    val dayPictureLiveData: LiveData<DayPictureData> get() = _dayPictureLiveData

    fun getDayPicture() {
        viewModelScope.launch() {
            _dayPictureLiveData.value = repository.getPictureOfDay()
        }
    }

    fun setToken(token: String) {
        repository.setToken(token)
    }
}