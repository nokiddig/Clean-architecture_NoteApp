package com.example.note_app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(var title:String,
                var content: String,
                val timestamp:Long)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

}