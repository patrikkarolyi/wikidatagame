package hu.bme.wikidatagame.WikiDataGame.greeting

import org.springframework.stereotype.Controller
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

}