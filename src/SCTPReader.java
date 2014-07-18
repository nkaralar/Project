/*
 * author: Nazli Karalar
 */

import java.io.InputStream;
import java.util.Scanner;

public class SCTPReader {
	public static byte[] bytes;
	public static int positionPointer = 0;

	public static void readHexStream(InputStream input) {
		String hexString = null;
		hexString = readHexAsString(hexString, input);
		convertToBytes(hexString);

		// changes position with respect to its message size
		PortInfo.determinePorts(positionPointer);
		// added 8 because verification tag and checksum are not considered
		ChunkInfo.determineChunkInfo(positionPointer + 8);
		IsdnInfo.determineIsdnInfo(positionPointer);
	}

	// reads stream as hex string
	private static String readHexAsString(String hexString, InputStream input) {
		Scanner scanner = new Scanner(input);
		while (scanner.hasNext()) {
			hexString = scanner.next(); // keeps SCTP hex stream
		}
		return hexString;
	}

	// divides hex string into substring and convert them to byte
	private static void convertToBytes(String hexString) {
		bytes = new byte[hexString.length() / 2];
		for (int i = 0; i < hexString.length(); i += 2) {
			int hex = Integer.parseInt(hexString.substring(i, i + 2), 16);
			bytes[i / 2] = (byte) (hex & 0xff);
		}
	}

	public static int getPositionPointer() {
		return positionPointer;
	}

	public static void setPositionPointer(int positionPointer) {
		SCTPReader.positionPointer = positionPointer;
	}

}
