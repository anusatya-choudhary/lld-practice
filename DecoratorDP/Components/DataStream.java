package Components;

public interface DataStream {
    String read();
    void write(String data);
    String getDescription();
}
