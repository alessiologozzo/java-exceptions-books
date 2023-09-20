package org.lessons.java.books;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.lessons.java.books.utils.InputInterface;

public class Main {

	public static void main(String[] args) {
		final String FILE_PATH = "file.txt";
		Scanner scanner = new Scanner(System.in);

		int dim = InputInterface.getInt(scanner, 1, 100, "Quanti libri vuoi inserire?");
		Book[] books = new Book[dim];
		for (int i = 0; i < dim; i++) {
			String title = InputInterface.getString(scanner, "N°" + (i + 1) + ") Come si chiama il libro?");
			String author = InputInterface.getString(scanner, "N°" + (i + 1) + ") Come si chiama il suo autore?");
			String publisher = InputInterface.getString(scanner, "N°" + (i + 1) + ") Qual è il suo editore?");
			int pageNumber = InputInterface.getInt(scanner, 1, "N°" + (i + 1) + ") Quante pagine ha?");

			try {
				books[i] = new Book(title, author, publisher, pageNumber);
			} catch (Exception e) {
				System.err.println("Errore durante l'inizializzazione del libro " + "N°" + (i + 1) + ".");
				i--;
			}
		}

		scanner.close();

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(FILE_PATH);

			for (int i = 0; i < dim; i++)
				fileWriter.write(books[i].toString() + "\n\n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		String fileContent = "";
		File file = new File(FILE_PATH);
		try {
			scanner = new Scanner(file);

			while (scanner.hasNextLine())
				fileContent += scanner.nextLine() + "\n";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}

		System.out.println("\n" + fileContent);
		System.out.println("\n\nArrivederci!");
	}

}
