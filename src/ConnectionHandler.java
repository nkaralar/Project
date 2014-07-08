

/*
 * author: Nazli Karalar
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionHandler implements Runnable {
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public ConnectionHandler(ServerSocket s) {
		serverSocket = s;
	}

	@Override
	public void run() {
		Scanner scanner;
		try {
			clientSocket = serverSocket.accept();
			// creates writer and reader to exchange data
			PrintWriter serverOutput = new PrintWriter(
					clientSocket.getOutputStream(), true);
			Scanner inputFromClient = new Scanner(clientSocket.getInputStream());

			// creates scanner to read input from user
			scanner = new Scanner(System.in);
			printDialog(scanner, serverOutput, inputFromClient);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// displays the message and answer dialog
	private void printDialog(Scanner scanner, PrintWriter serverOutput,
			Scanner inputFromClient) {
		String clientInput;
		System.out.println("Enter a msg number: ");
		while ((clientInput = inputFromClient.nextLine()) != null) {
			sendAnswer(serverOutput, clientInput);
			askForAnswers(scanner, serverOutput, inputFromClient);
			System.out.println("\nEnter a msg number: ");

		}
	}

	// sends the answer that server asks for
	private void sendAnswer(PrintWriter output, String clientInput) {
		int msgNo = Integer.parseInt(clientInput);
		output.println(Answers.createAnswers(msgNo));
	}

	// asks for the answer of its message from client
	private void askForAnswers(Scanner scanner, PrintWriter output,
			Scanner input) {
		int msgNo = scanner.nextInt();
		output.println(Messages.createMessages(msgNo));
		System.out.println("Client: " + input.nextLine());
	}

}
