package buu.informatics.s59160081.projectterm_4.screens.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "game_score_table")
data class GameScore (
    @PrimaryKey(autoGenerate = true)
    var gameId: Long = 0L,

    @ColumnInfo(name = "user_name")
    var username: String = "",

    @ColumnInfo(name = "user_score")
    var score: Int = 0
)
