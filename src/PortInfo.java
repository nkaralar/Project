
/*
 * author: Nazli Karalar
 */

public class PortInfo extends SCTPReader {

	// determine source and destination ports
	public static void determinePorts(int pointer) {
		int sourcePort, destinationPort;
		// finds decimal value of ports, 0xff is to obtain unsigned values
		// '<< 8' shifts hex to the left by 2
		sourcePort = (bytes[pointer] << 8) | bytes[pointer + 1] & 0xff;
		destinationPort = (bytes[pointer + 2] << 8) | bytes[pointer + 3] & 0xff;

		// position pointer becomes 4
		pointer += 4;
		setPositionPointer(pointer);
	}

}
