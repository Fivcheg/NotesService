package ru.netology

import ru.netology.NotesService.comments
import ru.netology.NotesService.commentsCreate
import ru.netology.NotesService.commentsDelete
import ru.netology.NotesService.notes
import ru.netology.NotesService.notesAdd
import ru.netology.NotesService.notesDelete
import kotlin.random.Random



fun main() {
    notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
    notesAdd(Note(1, 2234567, 130, "asdasddas", "asdasda",2,  2,null, true))
    notesAdd(Note(2, 342321542, Random.nextInt(from = 1, until = 250), "asdasddas", "asdasda",2,  3,null, false))
    notesAdd(Note(5, 22112022, Random.nextInt(from = 1, until = 250), "asdasd", "A<JSdak", 3, 2, null, false))
    notesAdd(Note(6, 5234567, 130, "asdasd", "A<JfgdSdak", 3, 2, null, false))
    notesAdd(Note(10, 22112022, Random.nextInt(from = 1, until = 250), "asdasd", "A<JSdak", 3, 2, null, false))
    commentsCreate(1, Comment(1, 1, 232232, 23, 3, 23, "dasda", "fdsgdf345", false))
    commentsCreate(2, Comment(2, 2, 23332232, 21, 3, 23, "dasdaaaadasd32a", "f211dsgdadf345", false))
    commentsCreate(2, Comment(3, 2, 23332232, 21, 3, 23, "dasdaaaad1241224asd32a", "f211231dsgdadf345", true))
    commentsCreate(2, Comment(3, 2, 23332232, 21, 3, 23, "dasdaaaad12a", "f211231ds5", true))
    commentsCreate(2, Comment(5, 2, 23332232, 21, 3, 23, "d352asdaaaad12a", "f211ds5", true))

/* for (item in comments) println(item)
 println("------")
 println(commentsDelete(0))
 for (item in comments) println(item)*/

/*   println("------")
 for (item in notes) println(item)
 println("------")
 println(notesDelete(5))
 for (item in notes) println(item)*/

}