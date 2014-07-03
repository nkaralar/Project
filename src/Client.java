/*
 * author: Nazli Karalar
 */

import java.io.IOException;
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
		Scanner input, scanner;
		PrintWriter output;

		try {
			// creates socket to connect PORT = 9900 on the 'localhost'
			socket = new Socket("localhost", PORT);
			// creates writer and reader to transmit and receive data
			output = new PrintWriter(socket.getOutputStream(), true);
			input = new Scanner(socket.getInputStream());
			scanner = new Scanner(System.in);

			printDialog(input, scanner, output);

			// delays 1s in order to prevent the readers and the writer to close
			// early
			Thread.sleep(1000);
			output.close();
			input.close();
			scanner.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("Port error in Client");
		}
	}

	// shows the dialog between client and server in client part
	private void printDialog(Scanner input, Scanner scanner, PrintWriter output)
			throws IOException {
		String text, msg, textToServer;
		int msgNo, messageNo = 0;
		System.out.println("Enter a msg number: ");
		while ((text = scanner.nextLine()) != null) {
			askForAnswer(input, output, text);
			sendAnswer(input, output);
		}
	}

	private void askForAnswer(Scanner input, PrintWriter output, String text) {
		String msg;
		int msgNo;
		msgNo = Integer.parseInt(text);
		Messages message = new Messages(msgNo);
		output.println(message.createMessages());
		msg = input.nextLine();
		System.out.println("Server: " + msg);
	}

	private void sendAnswer(Scanner input, PrintWriter output) {
		String textToServer;
		int messageNo;
		messageNo = Integer.parseInt(input.nextLine());
		Answers answer = new Answers(messageNo);
		textToServer = answer.createAnswers();
		output.println(textToServer);
		System.out.print("\nEnter a msg number: ");
	}

}
