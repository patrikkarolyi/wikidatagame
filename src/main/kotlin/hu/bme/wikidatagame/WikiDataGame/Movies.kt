package hu.bme.wikidatagame.WikiDataGame

import javax.persistence.*

@Entity
data class Movies(
        @Id
        val ID: Int,
        @Column(name = "Title")
        val title: String,
        @Column(name = "WikidatamovieID")
        val movieid: String,
        @Column(name = "GenreID")
        val genreid: String,
        @Column(name = "done")
        val done: Boolean
)