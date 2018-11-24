package hu.bme.wikidatagame.WikiDataGame.movies

import javax.persistence.*

@Entity
data class Movies(
        @Id
        val id: Int,
        @Column(name = "Title")
        val title: String,
        @Column(name = "WikidatamovieID")
        val wdmovieid: String,
        @Column(name = "GenreID")
        val genreid: String,
        @Column(name = "done")
        val solved: Boolean
)