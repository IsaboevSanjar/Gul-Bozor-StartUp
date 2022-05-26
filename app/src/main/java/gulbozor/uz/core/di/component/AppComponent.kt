package gulbozor.uz.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import gulbozor.uz.core.app.App
import gulbozor.uz.core.di.appContext.ContextModule
import gulbozor.uz.core.di.network.client.ClientModule
import gulbozor.uz.core.di.network.retrofit.NetworkRetrofitModule
import gulbozor.uz.core.di.repo.RepoModule
import gulbozor.uz.core.di.ui.ActivityBuilderModule
import javax.inject.Singleton


@Component(
    modules = [
        AndroidInjectionModule::class,  // buni har doim yozish kere
        ContextModule::class,
        ClientModule::class,
        NetworkRetrofitModule::class,
        RepoModule::class,
        ActivityBuilderModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}