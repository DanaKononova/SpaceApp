package com.example.spaceapp.ui.earth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceapp.domain.Repository
import com.example.spaceapp.domain.models.DateData
import com.example.spaceapp.domain.models.EarthImage
import kotlinx.coroutines.launch
import javax.inject.Inject

class EarthViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _datesLiveData = MutableLiveData<List<DateData>>()
    val datesLiveData: LiveData<List<DateData>> get() = _datesLiveData

    private val _imageNameLiveData = MutableLiveData<EarthImage>()
    val imageNameLiveData: LiveData<EarthImage> get() = _imageNameLiveData

    fun getDates() {
        viewModelScope.launch() {
            _datesLiveData.value = repository.getDates()
        }
    }

    fun getImageName(date: String){
        viewModelScope.launch() {
            _imageNameLiveData.value = repository.getImageName(date)
        }
    }

}