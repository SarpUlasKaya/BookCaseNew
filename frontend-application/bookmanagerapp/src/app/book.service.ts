import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Book } from "./book";

/** This class sends the HTTP requests to the backend. */
@Injectable({providedIn: 'root'})
export class BookService {  
  private apiServerUrl = environment.apiBaseUrl; /** Specified in environment.ts */

  constructor(private http: HttpClient){}

  /** Sends a GET request to the backend for all the books. */
  public getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.apiServerUrl}/book/all`);
  }

  /** Sends a POST request to the backend to add a book. */
  public addBook(book: Book): Observable<Book> {
    return this.http.post<Book>(`${this.apiServerUrl}/book/add`, book);
  }

  /** Sends a PUT request to the backend to update a book. */
  public updateBook(book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.apiServerUrl}/book/update`, book);
  }

  /** Sends a DELETE request to the backend to update a book. */
  public deleteBook(bookId: number | undefined): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/book/delete/${bookId}`);
  }
}