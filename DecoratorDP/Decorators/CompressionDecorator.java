package Decorators;

import Components.DataStream;

public class CompressionDecorator extends StreamDecorator{
    public CompressionDecorator(DataStream dataStream){
        super(dataStream);
    }

    @Override
    public String read(){
        String compressed = dataStream.read();
        return decompress(compressed);
    }

    @Override
    public void write(String data){
        String compressed = compress(data);
        super.write(compressed);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " (Compressed)";
    }

    private String compress(String data){
        return "COM[" + data + "]";
    }

    private String decompress(String data){
        return data.replace("COM[", "").replace("]", "");
    }
} 

