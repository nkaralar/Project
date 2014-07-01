/*
 * author: Nazli Karalar
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionHandler implements Runnable {
	private Server server;
	private Socket clientSocket;
	private ServerSocket serverSocket;

	public ConnectionHandler(Socket s) {
		clientSocket = s;
	}

	// gets server and client sockets specified in Server class
	public ConnectionHandler() {
		serverSocket = server.getServerSocket();
		clientSocket = server.getClientSocket();
	}

	@Override
	public void run() {
		Scanner scanner;
		try {
			// creates writer and readers to transmit and receive data
			PrintWriter output = new PrintWriter(
					clientSocket.getOutputStream(), true);
			Scanner input = new Scanner(clientSocket.getInputStream());
			scanner = new Scanner(System.in);
			printDialog(scanner, output, input);

			// delays 1s in order to prevent the reader, writer and the sockets
			// to close early
			Thread.sleep(1000);
			output.close();
			input.close();
			clientSocket.close();
			serverSocket.close();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	// shows the dialog between client and server in server part
	private void printDialog(Scanner scanner, PrintWriter output, Scanner input) {
		String text, clientInput;
		int msgNo;
		while ((clientInput = input.nextLine()) != null) {
			msgNo = Integer.parseInt(clientInput);
			Answers answer = new Answers(msgNo);
			text = answer.createAnswers();
			output.println(text);

		}
	}

}
