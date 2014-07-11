

import java.io.InputStream;
import java.util.Scanner;

public class SCTPReader {
	public static byte[] bytes;

	public static void readHexStream(InputStream input) {
		String hexString = null;
		hexString = readHexAsString(hexString, input);
		convertToBytes(hexString);
		int positionPointer = 0;
		// changes position with respect to its message size
		positionPointer = PortInfo.determinePorts(positionPointer);
		// added 8 because verification tag and checksum are not considered
		positionPointer = ChunkInfo.determineChunkInfo(positionPointer + 8);
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
}
