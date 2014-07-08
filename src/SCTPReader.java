

import java.io.InputStream;
import java.util.Scanner;

public class SCTPReader {
	public static byte[] bytes;
	
	public static void readHexStream(InputStream input) {
		String hexString = null;
		hexString = readHexAsString(hexString, input);
		convertToBytes(hexString);
	}

	// reads stream as hex string
	private static String readHexAsString(String hexString, InputStream input) {
		Scanner scanner = new Scanner(input);
		while (scanner.hasNext()) {
			hexString = scanner.next(); // keeps SCTP hex stream 
		}
		return hexString;
	}

	private static void convertToBytes(String hexString) {
		bytes = new byte[hexString.length() / 2];
		for (int i = 0; i < hexString.length(); i += 2) {
			int hex = Integer.parseInt(hexString.substring(i, i + 2), 16);
			bytes[i / 2] = (byte) (hex & 0xff);
		}

		for (int i = 0; i < bytes.length; i++) {
			System.out.printf("0x%02X", bytes[i]);
			System.out.println();
		}
	}
	
}
