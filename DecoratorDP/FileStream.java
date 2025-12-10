public class FileStream implements DataStream {
    private String fileName;

    public FileStream(String fileName){
        this.fileName = fileName;
    }

    @Override
    public String read(){
        return "Reading data from file: " + fileName;
    }

    @Override
    public void write(String data){
        System.out.println("Writing data to file: " + fileName);
        System.out.println("Data: " + data);
    }

    @Override
    public String getDescription(){
        return "FileStream: " + fileName;
    }
}
