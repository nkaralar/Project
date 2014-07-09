

public class ChunkInfo extends SCTPReader {
	private static byte chunkType, chunkFlag;

	public static void determineChunkInfo(int pointer) {
		byte[] chunkLength = new byte[2];
		byte[] initiateTag = new byte[4];
		determineTypeAndFlag(pointer);
		determineChunkLength(pointer, chunkLength);
		determineInitiateTag(pointer, initiateTag);
	}

	// determines chunk type and flag
	private static void determineTypeAndFlag(int pointer) {
		//pointer is 12 (chunk type position)
		chunkType = bytes[pointer];
		chunkFlag = bytes[pointer + 1];
	}

	private static void determineChunkLength(int pointer, byte[] chunkLength) {
		int j = 0;
		//position of chunk length is pointer+2 and its size is 2
		for (int i = pointer + 2; i < pointer + 4; i++) {
			chunkLength[j] = bytes[i];
			j++;
		}
	}
	
	//position of initiate tag is pointer+4 and its size is 4
	private static void determineInitiateTag(int pointer, byte[] initiateTag) {
		int j = 0;
		for (int i = pointer + 4; i < pointer + 8; i++) {
			initiateTag[j] = bytes[i];
			j++;
		}
	}

	public static byte getChunkType() {
		return chunkType;
	}

	public static byte getChunkFlag() {
		return chunkFlag;
	}

}
