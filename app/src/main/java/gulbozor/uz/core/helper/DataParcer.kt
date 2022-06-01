package gulbozor.uz.core.helper

import retrofit2.Response

// TODO:  shu yerdan data parcerni yaratib davom etaver
// Bu network call larni qabul qladigan Function
suspend fun <T> getAnnounceResult(call: suspend () -> Response<T>): Resource<T> {
    try {
        val response = call.invoke()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                return Resource.success(body)
            }
        }
        return Resource.error("Network Error" + response.message(), response.code())

    } catch (e: Exception) {
        return Resource.error(message = e.message)
    }
}