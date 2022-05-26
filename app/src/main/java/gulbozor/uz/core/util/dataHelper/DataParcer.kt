package gulbozor.uz.core.util.dataHelper

import com.google.gson.Gson
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


// TODO: Inline,reified key qolib ketdi
// inline hamda reified sozlari E-> class qilib chairib qolishga kerak bolgan LOOK 18 column
suspend inline fun <T, reified E> getResults(call: suspend () -> Response<T?>): Resource<T?, E> {
    return try {
        val resp = call.invoke()
        if (resp.isSuccessful) {
            val body = resp.body()
            Resource.Success(value = body)
        } else {
            try {
                if (resp.errorBody() != null) {
                    val errorResource = Gson().fromJson(resp.errorBody()!!.string(), E::class.java)
                    Resource.ErrorResponse(
                        code = resp.code(),
                        error = errorResource
                    )
                } else {
                    Resource.NetworkError(resp.code())
                }
            } catch (e: IOException) {
                Resource.NetworkError(resp.code(), e.message)
            } catch (e: HttpException) {
                val code = e.code()
                val errorResponse = Gson().fromJson(resp.errorBody()!!.string(), E::class.java)
                Resource.ErrorResponse(code, errorResponse)
            } catch (e: Exception) {
                Resource.NetworkError(resp.code())
            }
        }
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> {
                Resource.NetworkError(null, throwable.message)
            }
            is HttpException -> {
                val code = throwable.code()
                val errorResponse =
                    Gson().fromJson(throwable.response()?.errorBody()?.string(), E::class.java)
                Resource.ErrorResponse(code, errorResponse)
            }
            else -> {
                Resource.ErrorResponse(null, null)
            }
        }
    }


}