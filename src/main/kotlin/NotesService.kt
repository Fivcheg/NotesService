package ru.netology
import java.util.*
import javax.crypto.KeyGenerator

object NotesService {
    var notes = mutableListOf<Note>()  //TODO PRIVATE / OPEN FOR TESTING
    var comments = mutableListOf<Comment>() //TODO PRIVATE / OPEN FOR TESTING

    fun notesAdd(note: Note): Int {
        var newId = notes.size
        notes += note.copy(id = newId)
        if (newId == notes.last().id) {
            return notes.last().id
        }
        return 0
    }

    fun commentsCreate(postId: Int, comment: Comment): Boolean {
        val secretKey = KeyGenerator.getInstance("AES").generateKey()
        val encodedKey: String = Base64.getEncoder().encodeToString(secretKey.encoded)
        if (!notes[postId].deleted) {
            var commentId = comments.size
            comments += comment.copy(id = commentId++, noteId = postId, quid = encodedKey)
            if (commentId == comments.last().id) {
                return true
            }
        }
        return false
    }

    fun notesDelete(noteId: Int): Boolean {
        if (!notes[noteId].deleted) {
            notes += notes[noteId].copy(deleted = true)
            notes.removeAt(notes[noteId].id)
            return true
        }
        return false
    }

    fun commentsDelete(commentId: Int): Boolean {
        if (!comments[commentId].deleted && !notes[comments[commentId].noteId].deleted) {
            comments += comments[commentId].copy(deleted = true)
            comments.removeAt(comments[commentId].id)
            return true
        }
        return false
    }

    fun notesEdit(noteId: Int, title: String, text: String, privacy: Int, commentPrivacy: Int): Boolean {
        if (!notes[noteId].deleted) {
            notes += notes[noteId].copy(title = title, text = text, privacy = privacy, commentPrivacy = commentPrivacy)
            notes.removeAt(noteId)
            return true
        }
        return false
    }

    fun commentsEdit(commentId: Int, ownerId: Int, message: String): Boolean {
        if (!comments[commentId].deleted && !notes[comments[commentId].noteId].deleted) {
            comments += comments[commentId].copy(ownerId = ownerId, message = message)
            comments.removeAt(commentId)
            return true
        }
        return false
    }

    fun notesGet(userId: Int, count: Int, sort: Boolean): Any {
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

    fun notesGetById(noteId: Int): Any {
        var noteTemp = mutableListOf<Note>()
        for (item in notes) {
            if (item.id == noteId && !item.deleted) {
                noteTemp += item
            }
        }
        return noteTemp
    }

    fun commentsGet(noteId: Int, sort: Boolean, count: Int): Any {
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

    fun commentsRestore(commentId: Int): Boolean {
        if (comments[commentId].deleted && !notes[comments[commentId].noteId].deleted) {
            comments += comments[commentId].copy(deleted = false)
            comments.removeAt(commentId)
            return true
        }
        return false

    }
}

