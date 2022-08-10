package bike.rapido.movie_app

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepository {
    private val api:Api
    init{
        val retrofit =  Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(Api::class.java)
    }

    fun getPopularMoviesList(){
        api.getPopularMovies().enqueue(object :Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val responseBody = response.body()
                if(response.isSuccessful){
                    Log.d("API Response","${responseBody?.movies}")

                }else {
                    Log.e("API Response", "Failed to get response. $responseBody")
                }

            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("API Response", "Failed to get response")
            }

        })
    }


}