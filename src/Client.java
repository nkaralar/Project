/*
 * author: Nazli Karalar
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static int PORT = 9980;

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		connect();
	}

	// establishes client connection
	private void connect() {
		Socket socket = null;
		Scanner scanner, inputFromUser;
		PrintWriter output;

		try {
			// creates socket to connect PORT = 9900 on the 'localhost'
			socket = new Socket("localhost", PORT);
			// creates writer and reader to transmit and receive data
			output = new PrintWriter(socket.getOutputStream(), true);
			scanner = new Scanner(socket.getInputStream());
			inputFromUser = new Scanner(System.in);

			printDialog(scanner, inputFromUser, output);

			// delays 1s in order to prevent the readers and the writer to close
			// early
			Thread.sleep(1000);
			output.close();
			scanner.close();
			inputFromUser.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("Port error in Client");
		}
	}

	// shows the dialog between client and server in client part
	private void printDialog(Scanner scanner, Scanner inputFromUser,
			PrintWriter output) throws IOException {
		String text, msg;
		int msgNo = 0;
		System.out.println("Enter a msg number: ");
		while ((text = inputFromUser.nextLine()) != null) {
			msgNo = Integer.parseInt(text);
			Messages message = new Messages(msgNo);
			output.println(message.createMessages());
			msg = scanner.nextLine();
			System.out.println("Server: " + msg);
			System.out.print("\nEnter a msg number: ");
		}
	}
}
