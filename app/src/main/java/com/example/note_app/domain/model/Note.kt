package com.example.note_app.domain.model

data class Note(var title:String,
                var content: String,
                val timestamp:Long) {
    @PrimaryKey

}