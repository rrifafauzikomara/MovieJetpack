package com.rifafauzi.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.rifafauzi.moviecatalogue.di.Injection
import com.rifafauzi.moviecatalogue.helper.repository.Repository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(factoryClass: Class<T>) :T{
        return  when{
            factoryClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(repository) as T
            factoryClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel: " + factoryClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Injection.repository()?.let { ViewModelFactory(it) }
                    }
                }
            }
            return INSTANCE
        }

    }

}
