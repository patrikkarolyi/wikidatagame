package hu.bme.wikidatagame.WikiDataGame.movies

import org.springframework.data.repository.CrudRepository


interface MovieRepository: CrudRepository<Movies, Int>