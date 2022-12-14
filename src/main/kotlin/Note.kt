package ru.netology
data class Note(
    val id: Int,
    val date: Long,
    val userId: Int,
    val title: String,
    val text: String,
    val privacy: Int,
    val commentPrivacy: Int,
    val comment: Comment?,
    val deleted: Boolean
)