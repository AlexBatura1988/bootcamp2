package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	private final  int PORT = 8080;
	private final static String HOSTNAME = "localhost";
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public TcpClient() throws UnknownHostException, IOException {
		clientSocket = new Socket(HOSTNAME,PORT);
	}

}
