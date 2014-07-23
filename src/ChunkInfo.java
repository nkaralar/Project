/*
 * author: Nazli Karalar
 */

/**
 * This class keeps the chunk information that is read from socket stream
 * Updates the position with respect to chunk info length
 */

public class ChunkInfo extends SCTPReader {
	private static byte chunkType, chunkFlag;
	private static int chunkLength;

	public static void determineChunkInfo(int pointer) {
		determineTypeAndFlag(pointer);
		determineChunkLength(pointer);
		if (chunkType != 0) {
			// every chunk type has own length
			pointer += chunkLength;

		} else {
			// chunk length includes isdn message size as well
			// every data chunk (its type=0) consists of 16 bytes, so adds 16
			pointer += 16;
		}
		setPositionPointer(pointer);
	}

	private static void determineTypeAndFlag(int pointer) {
		// pointer is 12 (chunk type position)
		chunkType = bytes[pointer];
		chunkFlag = bytes[pointer + 1];
	}

	private static void determineChunkLength(int pointer) {
		pointer += 2; // chunk length starts at pointer 14
		// finds decimal value of chunk length, 0xff is to obtain unsigned
		// values
		chunkLength = (bytes[pointer] << 8) | bytes[pointer + 1] & 0xff;
	}

	public static byte getChunkType() {
		return chunkType;
	}

	public static byte getChunkFlag() {
		return chunkFlag;
	}

}
