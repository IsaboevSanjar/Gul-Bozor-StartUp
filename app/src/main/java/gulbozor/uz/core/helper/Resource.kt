package gulbozor.uz.core.helper

data class Resource<out T>(
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null,
    val status: Status
) {

    enum class Status {
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(data = data, status = Status.SUCCESS)
        }

        fun <T> error(message: String? = null, code: Int? = null): Resource<T> {
            return Resource(message = message, code = code, status = Status.ERROR)
        }
    }

}
