package bike.rapido.movie_app

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Paint
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieTextView: TextView = itemView.findViewById(R.id.movie_title)
        private val movieDescription: TextView = itemView.findViewById(R.id.movie_description)
        private val moviePoster: ImageView = itemView.findViewById(R.id.movie_image);

        @SuppressLint("PrivateResource")
        fun bind(movie: Movie) {
            movieTextView.text = movie.title
            movieTextView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
            movieDescription.text = movie.overview
            val posterUrl:String = "https://image.tmdb.org/t/p/w500/${movie.poster}"
            Picasso.get().load(posterUrl)
                .placeholder(androidx.core.R.drawable.notification_bg)
                .error(com.google.android.material.R.drawable.mtrl_ic_error)
                .into(moviePoster);
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