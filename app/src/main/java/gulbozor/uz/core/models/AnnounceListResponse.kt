package gulbozor.uz.core.models

/*
*
* [
  {
    "active": true,
    "allowed": true,
    "createAt": {},
    "description": "string",
    "diameter": 0,
    "flowerType": 0,
    "height": 0,
    "id": 0,
    "mainAttachId": 0,
    "price": 0,
    "shopId": 0,
    "title": "string",
    "weight": 0,
    "withFertilizer": true,
    "withPot": true
  }
]*/
data class CratedAt(
    val date: Int,
    val day: Int,
    val hours: Int,
    val minutes: Int,
    val month: Int,
    val nanos: Int,
    val seconds: Int,
    val time: Int,
    val timezoneOffset: Int,
    val year: Int,
)

data class GetAnnounceList(
    val active: Boolean,
    val allowed: Boolean,
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