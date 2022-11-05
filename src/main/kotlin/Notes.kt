data class Notes(
    val id: Int,
    val date: Long,
    val userId: Int,
    val text: String,
    val comment: Comment,
    val deleted: Boolean
)