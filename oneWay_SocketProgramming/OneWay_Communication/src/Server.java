import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss=new ServerSocket(500);
        System.out.println("Waiting for client : ");
        Socket s=ss.accept();
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());

        System.out.println("Client Requested accepted at port number : "+s.getLocalPort());
        String msg=" ";
        while (!msg.equals("stop")) {
            String str =dis.readUTF();
            System.out.println("Client message is : "+str);
        }
        dis.close();
        dos.close();
        ss.close();
        s.close();
        
    }
}
