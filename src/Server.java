
/*
 * author: Nazli Karalar
 */

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static int PORT = 9900;

	private static ServerSocket serverSocket;

	public static void main(String[] args) throws IOException {
		try {
			// creates server socket whose PORT is 9900
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server is ready for the connection.");
		} catch (Exception e) {
			System.out.println("Port error in Server");
		}

		// creates a thread in order to connect multiple clients
		new Thread(new ConnectionHandler(serverSocket)).start();

	}

}
