import NotesService.commentDelete
import NotesService.comments
import NotesService.createComment
import NotesService.notes
import NotesService.notesAdd
import NotesService.notesDelete
import kotlin.random.Random


fun main() {
    notes = mutableListOf(
        Note(1, 22112022, Random.nextInt(from = 1, until = 250), "asdasd", "A<JSdak", 3, null, false),
        Note(2, 34232542, Random.nextInt(from = 1, until = 250), "asdasddas", "asdasda",2,  null, true),
        Note(3, 342321542, Random.nextInt(from = 1, until = 250), "asdasddas", "asdasda",2,  null, false)
    )

    println(createComment(1, Comment(1, 1, 232232, 23, 3, 23, 2, "dasda", "fdsgdf345", false)))
    println(createComment(2, Comment(2, 2, 23332232, 21, 3, 23, 2, "dasdaaaadasd32a", "f211dsgdadf345", false)))
    println(createComment(2, Comment(3, 2, 23332232, 21, 3, 23, 2, "dasdaaaad1241224asd32a", "f211231dsgdadf345", false)))
    println(notesAdd(Note(5, 22112022, Random.nextInt(from = 1, until = 250), "asdasd", "A<JSdak", 3, null, false)))

    for (item in comments) println(item)
    println("-----")
    for (item in notes) println(item)

    println("-----")
    for (item in notes) println(item)
    println("-----")

    for (item in comments) println(item)
    println("-----")
}