package hu.bme.wikidatagame.WikiDataGame.movies

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
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

    @GetMapping("/index")
    fun greeting(model : Model) : String {
        model.addAttribute("movietitle","Benjamin Button különös élete")
        return "index"
    }

}