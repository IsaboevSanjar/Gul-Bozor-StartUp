package gulbozor.uz.core.util.dataHelper

sealed class ResourceExample<out T, out E>() {
    data class Success<out T>(val code: Int? = null, val value: T?) : ResourceExample<T, Nothing>()
    data class ErrorResponse<out L>(val code: Int? = null, val error: L?) :
        ResourceExample<Nothing, L>()

    data class NetworkError(val code: Int? = null, val message: String? = null) :
        ResourceExample<Nothing, Nothing>()
}