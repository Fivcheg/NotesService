import NotesService.commentDelete
import NotesService.comments
import NotesService.commentsEdit
import NotesService.commentCreate
import NotesService.noteGet
import NotesService.notes
import NotesService.notesAdd
import NotesService.notesDelete
import NotesService.notesEdit
import kotlin.random.Random



fun main() {
    notes = mutableListOf(
        Note(1, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false),
        Note(2, 2234567, 130, "asdasddas", "asdasda",2,  2,null, true),
        Note(3, 342321542, Random.nextInt(from = 1, until = 250), "asdasddas", "asdasda",2,  3,null, false)
    )

    println(commentCreate(1, Comment(1, 1, 232232, 23, 3, 23, "dasda", "fdsgdf345", false)))
    println(commentCreate(2, Comment(2, 2, 23332232, 21, 3, 23, "dasdaaaadasd32a", "f211dsgdadf345", false)))
    println(commentCreate(2, Comment(3, 2, 23332232, 21, 3, 23, "dasdaaaad1241224asd32a", "f211231dsgdadf345", false)))
    println(notesAdd(Note(5, 22112022, Random.nextInt(from = 1, until = 250), "asdasd", "A<JSdak", 3, 2, null, false)))
    notesAdd(Note(6, 5234567, 130, "asdasd", "A<JfgdSdak", 3, 2, null, false))
    /* for (item in comments) println(item)
     println("-----")
     commentsEdit(1, 5, "32523523")
     for (item in comments) println(item)
     println("-----")
      for (item in notes) println(item)
      println("-----")
      notesEdit(2, "sadsada", "r3v3,", 2, 3)
      println("-----")
      for (item in notes) println(item)*/
    println(noteGet(130, "sadasdas", 2, true))
}