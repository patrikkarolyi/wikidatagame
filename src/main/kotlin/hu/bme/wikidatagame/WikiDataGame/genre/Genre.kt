package hu.bme.wikidatagame.WikiDataGame.genre

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Genre(
        @Id
        val idgenre:Int,
        @Column(name="wikidatagenreid")
        val wdgenreId: String,
        @Column(name="name")
        val name: String
)