package gulbozor.uz.core.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import gulbozor.uz.core.di.component.DaggerAppComponent

class App : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}