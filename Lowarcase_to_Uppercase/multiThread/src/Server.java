import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(2340);
        System.out.println("Waiting for clients : ");
        while (true) {
            Socket s = ss.accept();
            System.out.println("A new Client is connected : " + s);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            Thread t = new ClientHandler(s, dos, dis);
            t.start();
        }
    }
}

class ClientHandler extends Thread {
    Socket soc;
    DataInputStream input;
    DataOutputStream output;

    ClientHandler(Socket s, DataOutputStream dos, DataInputStream dis) {
        this.soc = s;
        this.input = dis;
        this.output = dos;
    }

    public void run() {
        DateFormat forDate = new SimpleDateFormat("yy/mm/dd");
        DateFormat forTime = new SimpleDateFormat("hh:mm:ss");

        String received;
        
        while (true) {

            try {
                output.writeUTF("Enter your String : ");
                received = input.readUTF();
                String uppercaseString = received.toUpperCase();
                output.writeUTF(uppercaseString);
                break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
