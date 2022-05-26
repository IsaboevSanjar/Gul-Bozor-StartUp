package gulbozor.uz.core.network.networkservices

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadImagesService {
    @POST("/attachment/uploadSystem")
    @Multipart
    suspend fun uploadImages(
        @Part
        mainAttachId: MultipartBody.Part,
    ): String
}