package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Server {

	public static Map<String, String[]> map;

	private final int INPUT_BUFFER_SIZE = 1024;
	private static  int port = 5555;
	private DatagramSocket serverSocket;
	
	public Server() throws SocketException {
		this(port);
	}

	public Server(int port) throws SocketException {
		this.port = port;
		serverSocket = new DatagramSocket(port);
		initMap();

	}

	public void echoData() throws IOException {

		Scanner sc = new Scanner(System.in);
		byte[] receiveData = new byte[INPUT_BUFFER_SIZE];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, INPUT_BUFFER_SIZE);
		System.out.println("waiting from message..");
		while (true) {
			serverSocket.receive(receivePacket);
			InetAddress clientIPAddress = receivePacket.getAddress();
			int clientPort = receivePacket.getPort();
			String msg = new String(receivePacket.getData()).trim();
			System.out.println("Received data from " + clientIPAddress + " " + msg);
			String res = citiesDataResult(map, msg);
			byte[] sendData = res.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, clientPort);
			serverSocket.send(sendPacket);

		}

	}

	public String citiesDataResult(Map<String, String[]> map, String msg) {
		String res = "";
		Scanner sc = new Scanner(System.in);

		for (Map.Entry<String, String[]> pair : map.entrySet()) {
			if (msg.equals(pair.getKey())) {
				System.out.println("1. Temperature 2. Humidity 3. Temperature and humidity");
				switch (sc.nextInt()) {
				case 1:
					res = pair.getValue()[0];
					return res;
				case 2:
					res = pair.getValue()[1];
					return res;
				case 3:
					res = pair.getValue()[0] + "," + pair.getValue()[1];
					return res;
				}

			} else {
				res = "No City";
			}

		}
		return res;

	}

	private void initMap() {
		map = new HashMap<>();

		String[] arr1 = { "Tempreture = 30", "Humidity = 70" };
		String[] arr2 = { "Tempreture = 25", "Humidity = 60" };
		String[] arr3 = { "Tempreture = 10", "Humidity = 80" };
		String[] arr4 = { "Tempreture = 15", "Humidity = 40" };
		String[] arr5 = { "Tempreture = -20", "Humidity = 30" };

		map.put("Holon", arr1);
		map.put("Moscow", arr2);
		map.put("Toronto", arr3);
		map.put("Bat yam", arr4);
		map.put("Tel Aviv", arr5);

	}

	public static void main(String[] args) throws IOException {
		
		Server server = new Server();
		server.echoData();

	}

}
