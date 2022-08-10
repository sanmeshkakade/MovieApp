package bike.rapido.movie_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieTextView: TextView = itemView.findViewById(R.id.movie_title)
        private val movieDiscription: TextView = itemView.findViewById(R.id.movie_description)

        fun bind(movie: Movie) {
            movieTextView.text = movie.title
            movieDiscription.text = movie.overview
        }
    }

    // Returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    // Returns size of data list
    override fun getItemCount(): Int {
        return movies.size
    }

    // Displays data at a certain position
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

}