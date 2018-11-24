package hu.bme.wikidatagame.WikiDataGame.greeting

import hu.bme.wikidatagame.WikiDataGame.genre.GenreRepository
import hu.bme.wikidatagame.WikiDataGame.movies.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
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
    fun getMovie(model : Model) : String {
        val movie = movieRepository.findById(1).get()
        val genres = genreRepository.findAll()
        model.addAttribute("movie",movie)
        model.addAttribute("genres",genres)
        return "index"
    }

    @PostMapping("/index")
    fun submitMovie(@ModelAttribute greeting: Greeting): String {
        return "index"
    }

}