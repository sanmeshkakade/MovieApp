package bike.rapido.movie_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieListView:RecyclerView = findViewById(R.id.movieList)
        movieListView.layoutManager = LinearLayoutManager(this)


        MovieRepository.getPopularMoviesList(
            onSuccess = {
                Log.d("TAG", "Movie List Size:${it.size}")
                movieListView.adapter = MovieAdapter(it)
            },
            onError = {
                Log.e("TAG","Some error occurred")
            }
        )
    }
}