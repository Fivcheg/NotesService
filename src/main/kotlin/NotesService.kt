
import java.util.*
import javax.crypto.KeyGenerator

object NotesService {
    private var commentId = 0
    var notes = mutableListOf<Note>()  //TODO PRIVATE / OPEN FOR TESTING
    var comments = mutableListOf<Comment>() //TODO PRIVATE / OPEN FOR TESTING

    //Тут вроде ок
    fun notesAdd(note: Note): Int {
        val newId = notes.size + 1
        notes += note.copy(id = newId)
        if (newId == notes.last().id) {
            return notes.last().id
        }
        return 0
    }

    //Тут вроде ок
    fun commentCreate(postId: Int, comment: Comment): Boolean {
        val secretKey = KeyGenerator.getInstance("AES").generateKey()
        val encodedKey: String = Base64.getEncoder().encodeToString(secretKey.encoded)
        if (!notes[postId].deleted) {
            commentId = comments.size
            comments += comment.copy(id = ++commentId, noteId = postId, quid = encodedKey)
            if (commentId == comments.last().id) {
                return true
            }
        }
        return false
    }

    //Тут вроде ок
    fun notesDelete(noteId: Int): Boolean {
        if (!notes[noteId].deleted) {
            notes += notes[noteId].copy(deleted = true)
            notes.removeAt(notes.lastIndex - 1)
            return true
        }
        return false
    }

    //Тут вроде ок
    fun commentDelete(commentId: Int): Boolean {
        if (!comments[commentId].deleted && !notes[comments[commentId].noteId].deleted) {
            comments += comments[commentId].copy(deleted = true)
            comments.removeAt(notes.lastIndex - 1)
            return true
        }
        return false
    }

    //Тут вроде ок
    fun notesEdit(noteId: Int, title: String, text: String, privacy: Int, commentPrivacy: Int): Boolean {
        if (!notes[noteId].deleted) {
            notes += notes[noteId].copy(title = title, text = text, privacy = privacy, commentPrivacy = commentPrivacy)
            notes.removeAt(noteId)
            return true
        }
        return false
    }

    //Тут вроде ок
    fun commentsEdit(commentId: Int, ownerId: Int, message: String): Boolean {
        if (!comments[commentId].deleted && !notes[comments[commentId].noteId].deleted) {
            comments += comments[commentId].copy(ownerId = ownerId, message = message)
            comments.removeAt(commentId)
            return true
        }
        return false
    }

    //Тут вроде ок
    fun noteGet(userId: Int, count: Int, sort: Boolean): Any {
        var noteTemp = mutableListOf<Note>()
        var itemCount = 0
        for (item in notes) {
            if (item.userId == userId && !item.deleted && itemCount < count) {
                noteTemp += item
                itemCount++
            }
            //(false — по дате создания в порядке убывания, true - по дате создания в порядке возрастания).
            if (!sort) {
                noteTemp.sortByDescending { it.date }
            } else {
                noteTemp.sortBy { it.date }
            }
        }
        return noteTemp
    }

    //Тут вроде ок
    fun noteGetById(noteId: Int): Any {
        var noteTemp = mutableListOf<Note>()
        for (item in notes) {
            if (item.id == noteId && !item.deleted) {
                noteTemp += item
            }
        }
        return noteTemp
    }

    fun commentsGet(noteId: Int, ownerId: Int, sort: Boolean, count: Int): Any {
        var commentTemp = mutableListOf<Comment>()
        var itemCount = 0
        for (item in comments) {
            if (item.noteId == noteId && !item.deleted && !notes[noteId].deleted && itemCount < count) {
                commentTemp += item
                itemCount++
            }
            //(false — по дате создания в порядке убывания, true - по дате создания в порядке возрастания).
            if (!sort) {
                commentTemp .sortByDescending { it.date }
            } else {
                commentTemp .sortBy { it.date }
            }
        }
        return commentTemp
    }
}

