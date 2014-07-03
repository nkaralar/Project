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
			// creates writer and reader to exchange data
			PrintWriter serverOutput = new PrintWriter(
					clientSocket.getOutputStream(), true);
			Scanner inputFromClient = new Scanner(clientSocket.getInputStream());

			// creates scanner to read input from user
			scanner = new Scanner(System.in);
			printDialog(scanner, serverOutput, inputFromClient);

			// delays 1s in order to prevent the reader, writer and the sockets
			// to close early
			Thread.sleep(1000);
			serverOutput.close();
			inputFromClient.close();
			clientSocket.close();
			serverSocket.close();

		} catch (IOException | InterruptedException e) {
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
		Answers answer = new Answers(msgNo);
		output.println(answer.createAnswers());
	}

	// asks for the answer of its message from client
	private void askForAnswers(Scanner scanner, PrintWriter output,
			Scanner input) {
		int msgNo = scanner.nextInt();
		Messages message = new Messages(msgNo);
		output.println(message.createMessages());
		System.out.println("Client: " + input.nextLine());
	}

}
