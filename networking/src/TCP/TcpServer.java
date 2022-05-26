package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static final int PORT = 4413;
    
    private ServerSocket serverSocket;
  
    public TcpServer() throws IOException {
    	this.serverSocket = new ServerSocket(PORT);
        System.out.println("New client connected from " + serverSocket.getInetAddress().getHostAddress());
       
    }
  
    public void start() throws IOException {
    	Socket socket = serverSocket.accept();
        InputStream in = null;
        try {
            in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String request;
            request = br.readLine();
            System.out.println("Message received:" + request);
        } catch (IOException ex) {
            System.out.println("Unable to get streams from client");
        } finally {
            try {
                in.close();
                socket.close();
                System.out.println("Socket closed");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
		TcpServer server = new TcpServer();
		server.start();
	}

}
