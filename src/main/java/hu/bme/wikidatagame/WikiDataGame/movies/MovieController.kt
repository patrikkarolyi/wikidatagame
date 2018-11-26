package hu.bme.wikidatagame.WikiDataGame.movies

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = arrayOf("/movies"))
class MovieController {

    @Autowired
    private
    lateinit var movieRepository: MovieRepository

    @GetMapping(path = arrayOf("/all"))
    @ResponseBody
    fun getallUsers(): Iterable<Movies> {
        return movieRepository.findAll()
    }

}