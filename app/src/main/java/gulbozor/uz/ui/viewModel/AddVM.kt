package gulbozor.uz.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gulbozor.uz.core.helper.Resource
import gulbozor.uz.core.models.GetAnnounceList
import gulbozor.uz.core.repos.AddAnnounceRepo
import kotlinx.coroutines.launch

class AddVM : ViewModel() {

    private val repo = AddAnnounceRepo()
    private val announceLiveData: MutableLiveData<GetAnnounceList?> =
        MutableLiveData<GetAnnounceList?>()
    val errorResponse = MutableLiveData<String?>()
    fun getData() {
        viewModelScope.launch {
            val response = repo.getAddDataRepo()
            when (response.status) {
                Resource.Status.SUCCESS -> {
                    announceLiveData.postValue(response.data)
                }
                Resource.Status.ERROR -> {
                    errorResponse.postValue(response.message)
                }
            }
        }
    }
}