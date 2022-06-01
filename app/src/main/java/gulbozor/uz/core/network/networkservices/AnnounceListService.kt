package gulbozor.uz.core.network.networkservices

import gulbozor.uz.core.models.GetAnnounceList
import retrofit2.Response
import retrofit2.http.GET

interface AnnounceListService {
    @GET("/announce/announceList")
    suspend fun getAnnounce(): Response<GetAnnounceList>
}