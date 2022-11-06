
data class Note(
    val id: Int,
    val date: Long,
    val userId: Int,
    val title: String,
    val text: String,
    val privacy: Int,
    val comment: Comment?,
    val deleted: Boolean,
    var comments: MutableSet<Comment>? = mutableSetOf()
)