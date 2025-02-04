package es.upm.grise.profundizacion.control_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryTest {

  @Test
  public void testNewBookAddedSuccessfully() {

    String title = "Metro 2033";
    Book book = new Book(title);
    Library lib = new Library();

    try {
      lib.addBook(book);
      assertEquals(lib.getBook(title).getTitle(), title);
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void shouldThrowDuplicatedBookExceptionBecauseBookAlreadyInLibrary() {

    String title = "Metro 2033";
    Book book = new Book(title);
    Library lib = new Library();

    try {
      lib.addBook(book);
    }catch (Exception e) {
      e.printStackTrace();
    }

    assertThrows(DuplicatedBookException.class, () -> {
        lib.addBook(book);
      });
  }

  @Test
  public void testDeleteBookSuccessfully() {

    String title = "Metro 2033";
    Book book = new Book(title);
    Library lib = new Library();

    try {
      lib.addBook(book);
      lib.removeBook(book);
    }catch (Exception e) {
      e.printStackTrace();
    }

    assertThrows(NonExistingBookException.class, () -> {
        lib.getBook(title);
      });
  }

  @Test
  public void shouldThrowNonExistingBookExceptionBecauseBookNotInLibrary() {

    String title1 = "Metro 2033";
    Book book1 = new Book(title1);
    String title2 = "Metro 2035";
    Book book2 = new Book(title1);
    Library lib = new Library();

		try {
      lib.addBook(book1);
    }catch (Exception e) {
      e.printStackTrace();
    }
				
    assertThrows(NonExistingBookException.class, () -> {
        lib.removeBook(book2);
      });
  }

  @Test
  public void shouldThrowEmptyLibraryExceptionBecauseCannotRemoveBookFromEmptyLibrary() {

    String title = "Metro 2033";
    Book book = new Book(title);
    Library lib = new Library();

    assertThrows(EmptyLibraryException.class, () -> {
        lib.removeBook(book);
      });
  }

  @Test
  public void testGetBookSuccessfully() {

    String title = "Metro 2034";
    Book book = new Book(title);
    Library lib = new Library();

    try {
      lib.addBook(book);
			assertEquals(lib.getBook(title), book);
    }catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Test
  public void shouldThrowNonExistingBookExceptionBecauseCannotGetBookNotInLibrary() {

    String title1 = "Metro 2034";
    String title2 = "Metro 2035";
    Book book1 = new Book(title1);

    Library lib = new Library();

    try {
      lib.addBook(book1);
    }catch (Exception e) {
      e.printStackTrace();
    }

    assertThrows(NonExistingBookException.class, () -> {
        lib.getBook(title2);
      });
  }

  @Test
  public void shouldThrowEmptyLibraryExceptionBecauseCannotGetBookFromEmptyLibrary() {

    String title = "Metro 2034";
    Library lib = new Library();

    assertThrows(EmptyLibraryException.class, () -> {
        lib.getBook(title);
      });
  }
}
