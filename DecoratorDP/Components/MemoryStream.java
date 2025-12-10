public class MemoryStream implements DataStream {
    private String content;

    public MemoryStream(String content){
        this.content = content;
    }

    @Override
    public String read(){
        return "Reading data from memory: " + content;
    }

    @Override
    public void write(String data){
        System.out.println("Writing content to memory: " + content);
        System.out.println("Data: "+data);
    }

    @Override
    public String getDescription(){
        return "MemoryStream: " + content;
    }
}

