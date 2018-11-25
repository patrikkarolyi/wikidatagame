package hu.bme.wikidatagame.WikiDataGame.greeting

import hu.bme.wikidatagame.WikiDataGame.genre.GenreRepository
import hu.bme.wikidatagame.WikiDataGame.movies.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.concurrent.atomic.AtomicLong


@Controller
class GreetingController {

    val counter = AtomicLong()

    @GetMapping("/")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = "index"
    // Greeting(counter.incrementAndGet(), "Hello, $name")

    @PostMapping("/")
    fun greetingSubmit(@ModelAttribute greeting: Greeting): String {
        return "index"
    }

    @Autowired
    private
    lateinit var movieRepository: MovieRepository

    @Autowired
    private
    lateinit var genreRepository: GenreRepository


    @GetMapping("/index")
    fun getMovie(model: Model): String {
        setModelValues(model)
        return "index"
    }

    @PostMapping(value = ["/index"])
    fun submitMovie(genrevalue: String, movieid: String, model: Model): String {
        setModelValues(model)
        return "index"
    }


    fun setModelValues(model: Model) {
        val movie = movieRepository.findById(1).get()
        val genres = genreRepository.findAll()
        model.addAttribute("movie", movie)
        model.addAttribute("genres", genres)
    }

}