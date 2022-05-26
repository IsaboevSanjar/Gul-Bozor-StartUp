package gulbozor.uz.core.di.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import gulbozor.uz.ui.main.MainActivity

@Module
interface ActivityBuilderModule {

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}