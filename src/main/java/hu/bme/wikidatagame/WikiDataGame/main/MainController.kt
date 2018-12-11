package hu.bme.wikidatagame.WikiDataGame.main

import hu.bme.wikidatagame.WikiDataGame.genre.GenreRepository
import hu.bme.wikidatagame.WikiDataGame.movies.MovieRepository
import hu.bme.wikidatagame.WikiDataGame.movies.Movies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.util.concurrent.atomic.AtomicLong


@Controller
class MainController {

    val counter = AtomicLong()

    @Autowired
    private
    lateinit var movieRepository: MovieRepository

    @Autowired
    private
    lateinit var genreRepository: GenreRepository


    @GetMapping("/index")
    fun getMovie(model: Model): String {
        counter.set(9000L)
        setModelValues(model)
        return "index"
    }

    @PostMapping(value = ["/index"])
    fun submitMovie(genrevalue: String, movieid: String, model: Model): String {
        updateMovie(movieid,genrevalue)
        setModelValues(model)
        return "index"
    }

    private fun updateMovie(movieid: String, genrevalue: String) {
        val movieOptional = movieRepository.findById(movieid.toInt())

        if(movieOptional.isPresent){
            val movie = movieOptional.get()
            movieRepository.save(Movies(movie.id,movie.title,movie.wdmovieid,genrevalue,true))
        }

    }


    fun setModelValues(model: Model) {
        var movie = Movies(0,"We are out of the movies","a","a",false)
        val data = movieRepository.findById(counter.incrementAndGet().toInt())
                if(data.isPresent)
                   movie=data.get()
        val genres = genreRepository.findAll()
        model.addAttribute("movie", movie)
        model.addAttribute("genres", genres)
    }

}