

import java.io.InputStream;

public class PortInfoBytes extends SCTPReader {
	private static int HEX_BYTE_NUM = 2;
	private byte[] sourcePort, destinationPort;
	
	public PortInfoBytes(InputStream input) {
		initialize();
		determinePorts();
	}

	private void initialize() {
		sourcePort = new byte [HEX_BYTE_NUM];
		destinationPort = new byte[HEX_BYTE_NUM];
		
	}

	private void determinePorts() {
		for (int i = 0; i < sourcePort.length; i++) {
			sourcePort[i] = bytes [i];
			destinationPort[i] = bytes [i+2];
		}

		
	}
	
}
