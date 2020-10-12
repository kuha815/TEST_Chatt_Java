import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class ReceiveThread extends Thread{
    private Socket m_socket;

    public void run(){
        super.run();

        try{
            BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
            String receiveString;

            while(true){
                receiveString = tmpbuf.readLine();

                if(receiveString == null){
                    System.out.println("Lost Connection");
                    break;
                }
                else{
                    System.out.println("To : "+ receiveString);
                }
            }
            tmpbuf.close();
        }

        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setSocket(Socket socket){
        this.m_socket = socket;
    }
}
