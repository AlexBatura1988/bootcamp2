package udp_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private final static int INPUT_BUFFER_SIZE = 1024;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String serverName = "localhost";
		int serverPort = 4444;
		int port = 4445;
		DatagramSocket clientSocket = null;

		try {
			// creating client socket
			 clientSocket = new DatagramSocket(port);
			System.out.println("Client started on port " + port);
			// creating data
			String dataToSent = null;
			do {
			System.out.println("enter message to send");
			dataToSent = sc.nextLine();

			// creating datagram

			byte[] msgBytes = dataToSent.getBytes();
			DatagramPacket packetToSent = new DatagramPacket(msgBytes, msgBytes.length,
					InetAddress.getByName(serverName), serverPort);
			
			//send packet
			clientSocket.send(packetToSent);
			
			//prepeare packet for receuve data
			
			byte[] buffer = new byte[INPUT_BUFFER_SIZE];
			DatagramPacket receivePacket = new DatagramPacket(buffer,INPUT_BUFFER_SIZE);
			//receive data from server
			clientSocket.receive(receivePacket);
			String serverMsg = new String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength()).trim();
			 System.out.println("Server response " + serverMsg);
			 
			}while(!dataToSent.toLowerCase().equals("exit"));
			
			

		} catch (SocketException e) {
			System.err.println("client socket creation failed");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			System.err.println("server address could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("client failed to send data");
			e.printStackTrace();
		}finally {
			System.out.println("client disconected");
			if(clientSocket != null) {
				clientSocket.disconnect();
			}
		}

	}

}
