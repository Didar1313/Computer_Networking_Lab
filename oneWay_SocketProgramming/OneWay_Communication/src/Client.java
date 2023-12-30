import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 500);
        System.out.println("Connected");

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        Scanner scn = new Scanner(System.in);
        String toSend=" ";
        while (!toSend.equals("stop")) {
            System.out.println("Enter your Message : ");
            toSend = scn.nextLine();
            dos.writeUTF(toSend);
        }
        dos.close();
        s.close();
    }
}
