package hu.bme.wikidatagame.WikiDataGame.genre

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/genre"))
class GenreController {

    @Autowired
    private
    lateinit var genreRepository: GenreRepository

    @GetMapping(path = arrayOf("/all"))
    @ResponseBody
    fun getallUsers(): Iterable<Genre> {
        return genreRepository.findAll()
    }
}