import NotesService.createComment
import NotesService.notes
import kotlin.random.Random


fun main() {
    notes = mutableListOf(
        Note(1, 22112022, Random.nextInt(from = 1, until = 250), "asdasd", "A<JSdak", 3, null, false, null),
        Note(2, 34232542, Random.nextInt(from = 1, until = 250), "asdasddas", "asdasda",2,  null, true, null),
        Note(3, 342321542, Random.nextInt(from = 1, until = 250), "asdasddas", "asdasda",2,  null, true, null)
    )
    //println(notes.get(1))
   // println(addNote(Note(5, 34232542, Random.nextInt(from = 1, until = 250), "1asdasddas", "asdasda",2,  null, false)))

    println(createComment(1, Comment(1, 232232, 23, 3, 23, 2, "dasda", "fdsgdf345")))
    println(createComment(2, Comment(2, 23332232, 21, 3, 23, 2, "dasdaaaadasd32a", "f211dsgdadf345")))
    println(createComment(2, Comment(2, 23332232, 21, 3, 23, 2, "dasdaaaad1241224asd32a", "f211231dsgdadf345")))
   // println(getById(2))
    //println(notesDelete(2))
    //println(commentsTemp)
    println(notes[1])
    println(notes[0])
    println(notes[3])
    println(notes[4])
    println(notes[5])

}