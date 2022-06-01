package gulbozor.uz.core.models

data class AddAnnounce(
    val active: Boolean,
    val allowed: Boolean,
    // val categoryId: Int,
    val description: String,
    val diameter: Double,
    val flowerType: Int,
    val createAt: CratedAt,
    val height: Double,
    val price: Double,
    val id: Int,
    val mainAttachId: Int,
//val shopId:Int
    val title: String,
    val weight: Double,
    val withFertilizer: Boolean,
    val withPot: Boolean
)