data class Comment(
    val id: Int,
    val noteId: Int,
    val date: Long,
    val userId: Int,
    val ownerId: Int,
    val replyTo: Int,
    val message: String,
    val quid: String,
    val deleted: Boolean
)