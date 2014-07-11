/*
 * author: Nazli Karalar
 */

public class IsdnInfo extends SCTPReader {
	private static byte messageType;
	private static byte[] messageLength;

	public static void determineIsdnInfo(int pointer) {
		byte chunkType = ChunkInfo.getChunkType();
		if (chunkType == 0x00) {
			takeIsdnInfo(pointer);
		}

		if (chunkType == 0x03 && bytes.length > 28) {
			determineDataChunk(pointer);
		}
	}

	private static void takeIsdnInfo(int pointer) {
		messageType = bytes[pointer + 3];
		messageLength = new byte[4];
		int j = 0;
		for (int i = pointer + 4; i < pointer + 8; i++) {
			messageLength[j] = bytes[i];
			j++;
		}
	}

	private static void determineDataChunk(int pointer) {
		byte dataChunkType = bytes[pointer];
		byte[] chunkLength = new byte[2];
		int j = 0;
		for (int i = pointer + 2; i < pointer + 4; i++) {
			chunkLength[j] = bytes[i];
			System.out.printf("0x%02X", chunkLength[j]);
			j++;
			System.out.println();
		}
		byte msgTypeIsdn = bytes[pointer + 19];
		byte[] msgLength = new byte[4];
		int k = 0;
		for (int i = pointer + 20; i < pointer + 24; i++) {
			msgLength[k] = bytes[i];
			System.out.printf("0x%02X", msgLength[k]);
			k++;
			System.out.println();
		}
		// System.out.printf("0x%02X", msgTypeIsdn);
		// determineIsdnInfo(pointer);
		// System.out.printf("0x%02X", dataChunkType);

	}

	public static byte getMessageType() {
		return messageType;
	}

}
