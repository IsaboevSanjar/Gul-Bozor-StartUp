package gulbozor.uz.core.repos

import gulbozor.uz.core.helper.Resource
import gulbozor.uz.core.helper.getAnnounceResult
import gulbozor.uz.core.models.GetAnnounceList
import gulbozor.uz.core.network.ApiClientModule

class AddAnnounceRepo() {
    suspend fun getAddDataRepo(): Resource<GetAnnounceList> {
        val service = ApiClientModule.postAddAnnounceService()
        return getAnnounceResult {
            service.addAnnounceList()
        }
    }

}