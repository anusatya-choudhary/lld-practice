public class NetworkStream implements DataStream {
    private String serverAddress;

    public NetworkStream(String serverAddress){
        this.serverAddress = serverAddress;
    }

    @Override
    public String read(){
        return "Reading data from server: " + serverAddress;
    }

    @Override
    public void write(String data){
        System.out.println("Writing data to server: "+serverAddress);
        System.out.println("Data: " + data);
    }

    @Override
    public String getDescription(){
        return "NetworkStream: " + serverAddress;
    }
}
