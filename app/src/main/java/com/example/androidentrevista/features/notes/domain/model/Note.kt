package com.example.androidentrevista.features.notes.domain.model

data class Note (
    val id: Int,
    val title: String,
    val content: String,
){
    fun getTruncatedContent(): String =
        if (content.length > 100) {
            content.substring(0, 100) + "..."
        } else {
            content
        }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + content.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        if (id != other.id) return false
        if (title != other.title) return false
        if (content != other.content) return false

        return true
    }
}
