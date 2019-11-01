package com.vivekvishwanath.roomsprintchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
//ALL OF THIS IS BOILERPLATE CAN BE REUSED IN OTHER PROJECTS WITH NO CHANGE IF YOU HAVE AN ISSUE REMOVE SINGLETON
@Suppress("UNCHECKED_CAST")

class ViewModelProviderFactory @Inject constructor(


    //key = <Class<out ViewModel> value = Provider<ViewModel>> out is the same thing as extends in java
    val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
