package gulbozor.uz.core.util.dataHelper

sealed class Resource<out T, out E>() {
    data class Success<out T>(val code: Int? = null, val value: T?) : Resource<T, Nothing>()
    data class ErrorResponse<out L>(val code: Int? = null, val error: L?) : Resource<Nothing, L>()

    data class NetworkError(val code: Int? = null, val message: String? = null) :
        Resource<Nothing, Nothing>()
}