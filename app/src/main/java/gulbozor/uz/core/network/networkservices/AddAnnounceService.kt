package gulbozor.uz.core.network.networkservices

import gulbozor.uz.core.models.GetAnnounceList
import retrofit2.Response
import retrofit2.http.POST

interface AddAnnounceService {
    @POST("/announce")
    suspend fun addAnnounceList(): Response<GetAnnounceList>
}