import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.Comment
import ru.netology.Note
import ru.netology.NotesService
import ru.netology.NotesService.commentsCreate
import ru.netology.NotesService.commentsDelete
import ru.netology.NotesService.commentsEdit
import ru.netology.NotesService.commentsGet
import ru.netology.NotesService.commentsRestore
import ru.netology.NotesService.notesAdd
import ru.netology.NotesService.notesDelete
import ru.netology.NotesService.notesGet
import ru.netology.NotesService.notesGetById
import java.lang.IndexOutOfBoundsException
import kotlin.random.Random

class NotesServiceTest{
    @Before
    fun clearBeforeTest() {
        NotesService.clear()
    }
    @Test
    fun notesAddTrue() {
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        notesAdd(Note(1, 2234567, 130, "asdasddas", "asdasda", 2, 2, null, true))
        val result = notesAdd(Note(2, 342321542, Random.nextInt(from = 1, until = 250), "asdasddas", "asdasda",2,  3,null, false))
        assertEquals(2, result)
    }
    @Test
    fun commentsCreateTrue() {
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        commentsCreate(0, Comment(0, 1, 232232, 23, 3, 23, "dasda", "fdsgdf345", false))
        commentsCreate(0, Comment(1, 2, 23332232, 21, 3, 23, "dasdaaaadasd32a", "f211dsgdadf345", false))
        val result = commentsCreate(0, Comment(0, 0, 23332232, 21, 3, 23, "dasdaaaad1241224asd32a", "f211231dsgdadf345", false))
        assertTrue(result)
    }
    @Test(expected = IndexOutOfBoundsException::class)
    fun commentsCreateThrow(){
        commentsCreate(10, Comment(0, 0, 23332232, 21, 3, 23, "dasdaaaad1241224asd32a", "f211231dsgdadf345", false))
    }
    @Test
    fun notesDeleteTrue(){
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        val result = notesDelete(0)
        assertTrue(result)
    }
    @Test(expected = IndexOutOfBoundsException::class)
    fun notesDeleteThrow(){
         notesDelete(10)
    }
    @Test
    fun commentsDeleteTrue(){
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        commentsCreate(0, Comment(0, 1, 232232, 23, 3, 23, "dasda", "fdsgdf345", false))
        val result = commentsDelete(0)
        assertTrue(result)
    }
    @Test(expected = IndexOutOfBoundsException::class)
    fun commentsDeleteThrow(){
        commentsDelete(20)
    }
    @Test
    fun notesEditTrue(){
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        val result = NotesService.notesEdit(0, "sqada", "sdaadfff", 3, 2)
        assertTrue(result)
    }
    @Test(expected = IndexOutOfBoundsException::class)
    fun notesEditThrow(){
        NotesService.notesEdit(10, "sqada", "sdaadfff", 3, 2)
    }
    @Test
    fun commentsEditTrue(){
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        commentsCreate(0, Comment(0, 1, 232232, 23, 3, 23, "dasda", "fdsgdf345", false))
        val result = commentsEdit(0, 3,"asdasd")
        assertTrue(result)
    }
    @Test(expected = IndexOutOfBoundsException::class)
    fun commentsEditThrow(){
        commentsEdit(10, 3,"asdasd")
    }
    @Test
    fun notesGetTrue(){
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        notesAdd(Note(1, 2234567, 130, "asdasddas", "asdasda", 2, 2, null, false))
        val result: MutableList<Note> = notesGet(130, 5, true) as MutableList<Note>
        assertEquals(2, result.size)
    }
    @Test
    fun notesGetByIdTrue(){
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        notesAdd(Note(1, 2234567, 130, "asdasddas", "asdasda", 2, 2, null, false))
        val result: MutableList<Note> = notesGetById(0) as MutableList<Note>
        assertEquals(1, result.size)
    }
    @Test
    fun commentsGetTrue(){
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        commentsCreate(0, Comment(0, 1, 232232, 23, 3, 23, "dasda", "fdsgdf345", false))
        val result: MutableList<Comment> = commentsGet(0, true, 5) as MutableList<Comment>
        assertEquals(1, result.size)
    }
    @Test
    fun commentsRestoreTrue(){
        notesAdd(Note(0, 3234567, 130, "asdasd", "A<JSdak", 3, 3, null, false))
        commentsCreate(0, Comment(0, 1, 232232, 23, 3, 23, "dasda", "fdsgdf345", true))
        val result = commentsRestore(0)
        assertTrue(result)
    }
    @Test(expected = IndexOutOfBoundsException::class)
    fun commentsRestoreThrow(){
        commentsRestore(10)
    }
}