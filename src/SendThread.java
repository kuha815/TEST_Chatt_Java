import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class SendThread extends Thread{
    private Socket m_socket;

    public void run(){
        super.run();

        try{
            BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter sendWriter = new PrintWriter(m_socket.getOutputStream());
            String sendString;

            while(true){
                sendString = tmpbuf.readLine();

                sendWriter.println(sendString);
                sendWriter.flush();
            }
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setSocket(Socket socket){
        this.m_socket = socket;
    }
}
