package hu.bme.wikidatagame.WikiDataGame

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WikiDataGameApplication

fun main(args: Array<String>) {
    runApplication<WikiDataGameApplication>(*args)
}
