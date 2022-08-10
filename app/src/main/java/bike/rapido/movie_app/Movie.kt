package bike.rapido.movie_app

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val id:Int,
    @SerializedName("title") val title:String,
    @SerializedName("overview") val overview:String,
    @SerializedName("poster_path") val poster:String,
)