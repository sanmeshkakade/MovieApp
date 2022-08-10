package bike.rapido.movie_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MovieRepository.getPopularMoviesList(
            onSuccess = {
                Log.e("TAG", "Movie List Size:${it.size}")
            },
            onError = {
                Log.e("TAG","Some error occurred")
            }
        )
    }
}