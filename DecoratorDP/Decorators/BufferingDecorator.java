package Decorators;

import Components.DataStream;

public class BufferingDecorator extends StreamDecorator {
    public BufferingDecorator(DataStream dataStream){
        super(dataStream);
    }

    @Override
    public String read(){
         String buffered = dataStream.read();
         return unbuffer(buffered);
    }

    @Override
    public void write(String data){
        String buffered = buffer(data);
        super.write(buffered);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " (Buffered)";
    }

    private String buffer(String data){
        return "BUF[" + data + "]";
    }

    private String unbuffer(String data){
        return data.replace("BUF[", "").replace("]", "");
    }
}

