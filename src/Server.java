/*
 * author: Nazli Karalar
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static int PORT = 9900;
	private static ServerSocket serverSocket = null;
	private static Socket clientSocket = null;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		try {
			// creates server socket bound to PORT = 9900
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server is ready for the connection.");
			clientSocket = serverSocket.accept();

		} catch (Exception e) {
			System.out.println("Port error in Server");
		}

		// creates a thread in order to connect multiple clients
		new Thread(new ConnectionHandler(clientSocket)).start();
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

}
