package gulbozor.uz.core.di.network.client

import dagger.Module
import dagger.Provides
import gulbozor.uz.core.network.networkservices.UploadImagesService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
open class ClientModule {
    @Provides
    @Singleton
    open fun provideDoLoginService(retrofit: Retrofit): UploadImagesService {
        return retrofit.create(UploadImagesService::class.java)
    }
}