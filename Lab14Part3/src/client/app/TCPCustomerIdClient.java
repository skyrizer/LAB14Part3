package client.app;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import model.Customer;

public class TCPCustomerIdClient {

	public static void main(String[] args) {
		
try {
			
			System.out.println("\tExecuting TCPProductClientApp");
		
			// Server information
			int serverPortNo = 2509;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 1. Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			// Create stream to send request
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			// 2. Send request to the server
			int custId = 1;
			dos.writeInt(custId);
			System.out.println("\tRequesting customer id " + custId + "\n");
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			
			// 3. Read respond from the server - cast object
			Customer customer = (Customer) ois.readObject();
			
			// 4. Process response - display the object
			System.out.println("\tProduct Information (From the server)");
			System.out.println("\tProduct Id: " + customer.getCustomerId());
			System.out.println("\tName: " + customer.getCustomerName());
	
			
			
		} catch (Exception ex) {
			
			
			
		}

	}

}
