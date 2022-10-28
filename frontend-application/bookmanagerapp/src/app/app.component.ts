import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Book } from './book';
import { BookService } from './book.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

/** This class handles the UI Modal Logic of the frontend application. */
export class AppComponent implements OnInit { 
  public books!: Book[];
  public editBook: Book | null | undefined;
  public deleteBook: Book | null | undefined;
  
  constructor(private bookService: BookService){}

  /** Initialization function. Shows all the books upon entering the website. */
  ngOnInit() {
    this.getBooks();
  }

  /** The subscribe() function waits for the HTTP response to a request and executes a piece of code upon the type. */
  public getBooks(): void {
    this.bookService.getBooks().subscribe( {
      next: (response: Book[]) => {   /** The request returns the correct HTTP response */
        this.books = response;
      },
      error: (error: HttpErrorResponse) => { /** The request returns an HTTP error. */
        alert(error.message);
      }
    });
  }

  /** Requests to add book to the database by calling the addBook() function in book.service.ts */
  public onAddBook(addForm: NgForm): void {
    document.getElementById('add-book-form')?.click();
    this.bookService.addBook(addForm.value).subscribe({
      next: (response: Book) => {
        this.getBooks();
        addForm.reset();  /** Deletes the values that were previously entered to the same form. */
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    });
  }

  /** Requests to update a book on the database by calling the updateBook() function in book.service.ts */
  public onUpdateBook(book: Book): void {
    this.bookService.updateBook(book).subscribe({
      next: (response: Book) => {
        this.getBooks();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  /** Requests to delete a book on from the database by calling the deleteBook() function in book.service.ts */
  public onDeleteBook(bookId: number | undefined): void {
    this.bookService.deleteBook(bookId).subscribe({
      next: (response: void) => {
        this.getBooks();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  /** Lists books according to the user's input on their titles, authors or publishers. */
  public searchBooks(key: string): void {
    const results: Book[] = [];
    for (const book of this.books) { /** Both the attributes and the key entered are converted to lower case so that the search is not case-sensitive. */
      if (book.title.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || book.author.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || book.publisher.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(book);
      }
    }
    this.books = results;
    if (results.length === 0 || !key) { /** If there are no results for the search or no key is entered then list all the books as normal. */
      this.getBooks();
    }
  }

  /** This function assesses what the user is trying to do whenever they interact with the website. */
  public onOpenModal(book: Book | null, mode: string): void {
    const container = document.getElementById('main-container');
    
    /** Create a hidden button to be clicked in response to the user's action. */
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';

    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addBookModal'); /** Access the div with id=addBookModal on app.component.html */
    }
    if (mode === 'edit') {
      this.editBook = book;
      button.setAttribute('data-target', '#updateBookModal'); /** Access the div with id=updateBookModal on app.component.html */
    }
    if (mode === 'delete') {
      this.deleteBook = book;
      button.setAttribute('data-target', '#deleteBookModal'); /** Access the div with id=addBookModal on app.component.html */
    }

    /** Add the hidden button to the website and click it. */
    container?.appendChild(button); 
    button.click();

  }

}
