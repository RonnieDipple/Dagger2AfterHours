package com.vivekvishwanath.roomsprintchallenge.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

//BOILERPLATE
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
@Retention(AnnotationRetention.RUNTIME)
//The key for ViewModelProviderFactory
annotation class ViewModelKey (val value: KClass<out ViewModel>)