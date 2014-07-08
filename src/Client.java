

/*
 * author: Nazli Karalar
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static int PORT = 9900;

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		connect();

	}

	// establishes client connection
	private void connect() {
		Socket socket = null;
		Scanner inputFromServer, scanner;
		PrintWriter output;

		try {
			callSCTPReader();
			// creates socket to connect PORT = 9900 on the 'localhost'
			socket = new Socket("localhost", PORT);

			// creates writer and reader to exchange data
			output = new PrintWriter(socket.getOutputStream(), true);
			inputFromServer = new Scanner(socket.getInputStream());

			// creates scanner to read input from user
			scanner = new Scanner(System.in);
			printDialog(inputFromServer, scanner, output);
			
			// delays 1s in order to prevent the readers and the writer to close
			// early
			Thread.sleep(1000);
			output.close();
			inputFromServer.close();
			scanner.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("Port error in Client");
		}
	}

	// displays the message and answer dialog
	private void printDialog(Scanner inputFromServer, Scanner scanner,
			PrintWriter output) throws IOException {
		String textEntered;
		System.out.println("Enter a msg number: ");
		while ((textEntered = scanner.nextLine()) != null) {
			askForAnswer(inputFromServer, output, textEntered);
			sendAnswer(inputFromServer, output);
			System.out.print("\nEnter a msg number: ");
		}
	}

	// asks for the answer of its message from server
	private void askForAnswer(Scanner inputFromServer, PrintWriter output,
			String text) {
		int msgNo = Integer.parseInt(text);
		output.println(Messages.createMessages(msgNo));
		System.out.println("Server: " + inputFromServer.nextLine());
	}

	// sends the answer that server asks for
	private void sendAnswer(Scanner inputFromServer, PrintWriter output) {
		int msgNo = Integer.parseInt(inputFromServer.nextLine());
		output.println(Answers.createAnswers(msgNo));

	}

	private void callSCTPReader() {
		try {
			InputStream input = new FileInputStream(new File("a.txt"));
			SCTPReader.readHexStream(input);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
