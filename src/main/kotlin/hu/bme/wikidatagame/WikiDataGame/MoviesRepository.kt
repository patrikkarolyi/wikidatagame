package hu.bme.wikidatagame.WikiDataGame

import org.springframework.data.repository.CrudRepository


interface MoviesRepository: CrudRepository<Movies, Int>