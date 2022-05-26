package udp_server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * This is implementation of UDP server
 */
public class Server {

	private final static int INPUT_BUFFER_SIZE = 1024;
	private final static int OUTPUT_BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		int port = 4444;
		try {
			DatagramSocket serverSocket = new DatagramSocket(port);
			System.out.println("Server started on port " + port);

			// handle data
			byte[] inputBuffer = new byte[INPUT_BUFFER_SIZE];
			DatagramPacket receivedPacket = new DatagramPacket(inputBuffer, INPUT_BUFFER_SIZE);
			System.out.println("Server is listening on port " + port);

			// listening to clients

			while (true) {
				serverSocket.receive(receivedPacket);
				// get client address
				InetAddress clientAddress = receivedPacket.getAddress();
				int clientPort = receivedPacket.getPort();

				// get client msg
				String clientMsg = new String(receivedPacket.getData()).trim();

				// print client msg for debugging purpose
				System.out.println("client " + clientAddress + "  sent: " + clientMsg);
				// prepare packet for sending
				byte[] myBytes = clientMsg.getBytes();
				DatagramPacket packetToSent = new DatagramPacket(myBytes, myBytes.length, clientAddress, clientPort);
				//send packet to client
				serverSocket.send(packetToSent);
				System.out.println("Server echo response sent");
			}

		} catch (IOException e) {
			System.err.println(" Server Connection failed");
			e.printStackTrace();
		}

	}

}
