import java.util.*
import javax.crypto.KeyGenerator

object NotesService {
    var notes = mutableListOf<Note>()  //TODO PRIVATE / OPEN FOR TESTING


    fun addNote(note: Note): Int {
        val newId = notes.size + 1
        notes += note.copy(id = newId)
        return newId
    }

    fun createComment(postId: Int, comment: Comment): Int {
        var commentTemp: MutableSet<Comment> = mutableSetOf()
        val secretKey = KeyGenerator.getInstance("AES").generateKey()
        val encodedKey: String = Base64.getEncoder().encodeToString(secretKey.encoded)
        //var commentId = 0
        val note = getNoteById(postId)
        if (getNoteById(postId) != null) {
            commentTemp += comment.copy(quid = encodedKey)
            if (note != null) {
                notes += note.copy(comments = commentTemp)    // не могу понять как работать с Set'om в List'e, не копируя запись, а добавляя в Set новое значение
            }
        }
        return 1
    }

    fun notesDelete(noteId: Int): Boolean{
        var x = false
        if (getNoteById(noteId) != null && !getNoteById(noteId)!!.deleted) {
            notes += getNoteById(noteId)!!.copy(deleted = true)
            x = true
        }
        return x
    }

    fun getById(noteId: Int): Note? {
        return notes.firstOrNull { it.id == noteId }
    }

    private fun getNoteById(noteId: Int): Note?{
        return notes.firstOrNull { it.id == noteId }
    }
}
