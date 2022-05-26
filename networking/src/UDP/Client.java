package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private final static int INPUT_BUFFER_SIZE = 1024;
	private InetAddress serverAddress;
	private InetAddress clientAddres;
	private Scanner sc;
	private int serverPort;
	private int port;
	private DatagramSocket clientSocket;

	public Client(int serverPort, int port) throws SocketException, UnknownHostException {
		this.serverPort = serverPort;
		this.port = port;

		clientSocket = new DatagramSocket(port);
		clientAddres = InetAddress.getLocalHost();
		sc = new Scanner(System.in);

	}

	public void sendData() {
		while (true) {
			System.out.println("please enter city");
			String city = sc.nextLine();

			try {
				byte[] cityBytes = city.getBytes();
				DatagramPacket packet = new DatagramPacket(cityBytes, cityBytes.length, clientAddres, serverPort);
				clientSocket.send(packet);
			} catch (IOException e) {

				e.printStackTrace();
			}
			resiveData();

		}

	}

	public void resiveData() {
		try {
			byte[] buffer = new byte[INPUT_BUFFER_SIZE];
			DatagramPacket receivePacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);
			clientSocket.receive(receivePacket);
			String msg = new String(receivePacket.getData()).trim();
			System.out.println("from server " + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws SocketException, UnknownHostException {
		String serverName = "localHost";
		int serverPort = 5555;
		int localPort = 5554;
		Client client = new Client(serverPort, localPort);
		client.sendData();
		client.resiveData();
	}

}
