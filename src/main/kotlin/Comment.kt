data class Comment(
    val noteId: Int,
    val date: Long,
    val userId: Int,
    val ownerId: Int,
    val replyTo: Int,
    val commentPrivacy: Int,
    val message: String,
    val quid: String   // Можно было реализовать без quid через Set?
)