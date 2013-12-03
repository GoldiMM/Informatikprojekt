package dalmuti.server;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread{
	private Socket socket = null;
	protected long userID;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		){
			//definition was der server empfangen und senden kann
			//while-schlaufe mit der spiellogik
			
			//syso vom nickname
			String inputLine;
			userID = Thread.currentThread().getId();
			while ((inputLine = in.readLine()) != null) {
//				System.out.println(inputLine);
				//User user+userID = new User(userID, inputLine);
				User u = new User(1, inputLine);
				Spiellogik.userlist.add(u);
			}
			
		}catch (IOException e) {
            e.printStackTrace();
        }
	}

}
