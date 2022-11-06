
import java.util.*
import javax.crypto.KeyGenerator

object NotesService {
    var commentId = 0
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
    fun createComment(postId: Int, comment: Comment): Boolean {
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



    /* fun getById(noteId: Int): Note? {
        return notes.firstOrNull { it.id == noteId }
    }*/
}

