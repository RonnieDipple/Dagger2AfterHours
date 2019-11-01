package com.vivekvishwanath.roomsprintchallenge.di

import android.app.Application
import com.vivekvishwanath.roomsprintchallenge.view.FavoritesActivity
import com.vivekvishwanath.roomsprintchallenge.view.SearchActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton//Allows scoping ask yourself
// what want to use only one instance of
// inject constructor almost the same as @Provides
@Component(
    modules = [AppModule::class,
        AsyncTaskModule::class,
        ViewModelsModule::class]
)
//Does the injecting
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(application: Application): Builder

        //must pass the interface back

        fun build(): AppComponent
    }

    fun injectSearchActivity(activity: SearchActivity)

    fun injectFavoritesActivity(activity: FavoritesActivity)
}