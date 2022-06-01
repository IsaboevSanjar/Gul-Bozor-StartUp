package gulbozor.uz.core.repos

import gulbozor.uz.core.helper.Resource
import gulbozor.uz.core.helper.getAnnounceResult
import gulbozor.uz.core.models.GetAnnounceList
import gulbozor.uz.core.network.ApiClientModule

class HomeAnnounceRepo() {
    suspend fun getAnnounceDataRepo(): Resource<GetAnnounceList> {
        val service = ApiClientModule.getAnnounceService()
        return getAnnounceResult {
            service.getAnnounce()
        }
    }

}