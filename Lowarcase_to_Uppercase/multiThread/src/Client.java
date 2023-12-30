import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("localhost", 2340);
        System.out.println("Connected");
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        DataInputStream dis=new DataInputStream(s.getInputStream());
        Scanner scn=new Scanner(System.in);


        while (true) {
            System.out.println(dis.readUTF());
            String toSend=scn.nextLine();
            dos.writeUTF(toSend);
            String received;
            received=dis.readUTF();
            System.out.println(received);
        }
    }
}
