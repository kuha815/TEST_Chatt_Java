import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try{
            ServerSocket s_socket = new ServerSocket(8888);
            Socket c_socket = s_socket.accept();

            ReceiveThread rec_Thread = new ReceiveThread();
            rec_Thread.setSocket(c_socket);

            SendThread send_Thread = new SendThread();
            send_Thread.setSocket(c_socket);

            rec_Thread.start();
            send_Thread.start();
        }catch(IOException e){
            e.printStackTrace();
        }

        // 구현은 성공하였으나, Thread로 구현되어있음
    }
}
