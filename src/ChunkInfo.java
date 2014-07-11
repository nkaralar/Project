/*
 * author: Nazli Karalar
 */

public class ChunkInfo extends SCTPReader {
	private static int SIZE = 2;
	private static byte chunkType, chunkFlag;
	private static byte[] chunkLength;

	public static int determineChunkInfo(int pointer) {
		chunkLength = new byte[SIZE];
		determineTypeAndFlag(pointer);
		determineChunkLength(pointer, chunkLength);
		pointer += 16; // chunk length = 16 (it will be changed..)
		return pointer;
	}

	// determines chunk type and flag
	private static void determineTypeAndFlag(int pointer) {
		// pointer is 12 (chunk type position)
		chunkType = bytes[pointer];
		chunkFlag = bytes[pointer + 1];
	}

	private static void determineChunkLength(int pointer, byte[] chunkLength) {
		int j = 0;
		// position of chunk length is pointer+2 and its size is 2
		for (int i = pointer + 2; i < pointer + 4; i++) {
			chunkLength[j] = bytes[i];
			j++;
		}
	}

	public static byte getChunkType() {
		return chunkType;
	}

	public static byte getChunkFlag() {
		return chunkFlag;
	}

	public static byte[] getChunkLength() {
		return chunkLength;
	}
}
