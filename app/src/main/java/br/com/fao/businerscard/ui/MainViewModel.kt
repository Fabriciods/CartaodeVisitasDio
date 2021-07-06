package br.com.fao.businerscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fao.businerscard.data.BusinessCardRepository
import br.com.fao.businerscard.data.BusinessCard

class MainViewModel(private val businessCardRepository: BusinessCardRepository):ViewModel() {

    fun insert(businessCard: BusinessCard){
         businessCardRepository.insert(businessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>>{
        return businessCardRepository.getAll()
    }
}
class MainViewModelFactory(private val repository: BusinessCardRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return  MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}