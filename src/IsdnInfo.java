
/*
 * author: Nazli Karalar
 */

public class IsdnInfo extends SCTPReader {
	private static byte messageType;
	private static byte isdnMsgType;

	public static void determineIsdnInfo(int pointer) {
		byte chunkType = ChunkInfo.getChunkType();
		// according to chunk type, hex stream is changing
		// chunk type = 0 (data)
		if (chunkType == 0x00) {
			takeIsdnInfo(pointer);
		}
		// chunk type = 3 (sack), >28 for sack notify messages
		if (chunkType == 0x03 && bytes.length > 28) {
			determineSecondChunk(pointer);
		}
	}

	private static void takeIsdnInfo(int pointer) {
		// passes version, reserved and message class bytes
		messageType = bytes[pointer + 3];
		// finds decimal value of ports, 0xff is to obtain unsigned values
		// '<< 24' shifts hex to the left by 6, '<< 16' shifts by 4 ...
		int messageLength = (bytes[pointer + 4] << 24)
				| (bytes[pointer + 5] << 16) | (bytes[pointer + 6] << 8)
				| (bytes[pointer + 7]);
	}

	// reads chunk message coming after the data chunk
	private static void determineSecondChunk(int pointer) {
		byte secondChunkType = bytes[pointer];
		int chunkLength = (bytes[pointer + 2] << 8) | bytes[pointer + 3];
		pointer += 16;
		isdnMsgType = bytes[pointer + 3];
		int msgLength = (bytes[pointer + 4] << 24) | (bytes[pointer + 5] << 16)
				| (bytes[pointer + 6] << 8) | (bytes[pointer + 7]);
	}

	public static byte getIsdnMsgType() {
		return isdnMsgType;
	}

}
