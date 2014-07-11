/*
 * author: Nazli Karalar
 */

public class PortInfo extends SCTPReader {
	private static int SIZE = 2;

	// determine source and destination ports
	public static int determinePorts(int pointer) {
		byte[] sourcePort = new byte[SIZE];
		byte[] destinationPort = new byte[SIZE];
		for (int i = pointer; i < sourcePort.length; i++) {
			sourcePort[i] = bytes[i];
			destinationPort[i] = bytes[i + 2];
		}
		pointer += 2 * SIZE;
		return pointer;
	}

}
