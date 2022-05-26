package gulbozor.uz.core.di.network.retrofit

import android.app.Application
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
open class NetworkRetrofitModule {

    @Provides
    @Singleton
    open fun getChuckerCollector(context: Application): ChuckerCollector = ChuckerCollector(
        context = context,
        showNotification = true
    )

    @Provides
    @Singleton
    open fun getChuckerInterceptor(
        context: Application,
        chucker: ChuckerCollector
    ): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(collector = chucker)
            .maxContentLength(250_000L)
            .alwaysReadResponseBody(true)
            .build()
    }

    @Provides
    @Singleton
    open fun getHttpDoLoginInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    open fun getGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    open fun getApiClient(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://gulbazar.herokuapp.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    open fun interceptor(
        context: Context?
    ): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val request = chain.request()
            val builder: Request.Builder = request.newBuilder()
            builder.header("Connection", "close")
                .addHeader("Context-type", "application/json")
            val response = chain.proceed(builder.build())
            response
        }
    }

    @Provides
    @Singleton
    open fun getOkHttpClient(
        logging: HttpLoggingInterceptor,
        chucker: ChuckerInterceptor,
        interceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .hostnameVerifier { _, _ -> true }
            .addInterceptor(logging)
            .addInterceptor(chucker)
            .addInterceptor(interceptor)
            .build()
    }
}