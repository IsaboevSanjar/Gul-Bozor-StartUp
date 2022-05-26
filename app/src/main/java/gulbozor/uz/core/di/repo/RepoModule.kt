package gulbozor.uz.core.di.repo

import dagger.Module
import dagger.Provides
import gulbozor.uz.core.network.networkservices.UploadImagesService
import gulbozor.uz.core.repos.DoLoginRepo
import javax.inject.Singleton


@Module
open class RepoModule {
    @Provides
    @Singleton
    open fun provideDoLoginRepo(service: UploadImagesService): DoLoginRepo {
        return DoLoginRepo(service)
    }
}