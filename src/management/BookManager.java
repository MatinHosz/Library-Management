package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

import java.util.NoSuchElementException;

public class BookManager {

    private CustomHashMap<String, Book> booksById;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        booksById = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException();
        booksById.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return booksById.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {

        return booksById.get(isbn).isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        if (booksById.get(isbn) == null) {
            System.out.println("Book with isbn: " + isbn + " not found!");
            return;
        }

        booksById.get(isbn).setAvailable(available);
    }

    public void addToWaitlist(String isbn, String memberId) {
        if (memberManager.getMember(memberId) == null) {
            System.out.println("Member with memberID: " + memberId + " not found!");
            return;
        }
        if (booksById.get(isbn) == null) {
            System.out.println("Book with isbn: " + isbn + " not found!");
            return;
        }

        Member member = memberManager.getMember(memberId);
        booksById.get(isbn).addToWaitlist(member);
    }

    public Member getNextFromWaitlist(String isbn) {
        if (booksById.get(isbn) == null) {
            System.out.println("Book with isbn: " + isbn + " not found!");
            return null;
        }

        return booksById.get(isbn).getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        return booksById.get(isbn).hasWaitlist();
    }
}