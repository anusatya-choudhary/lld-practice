package Decorators;

import Components.DataStream;

public abstract class StreamDecorator implements DataStream {
    protected DataStream dataStream;
    
    public StreamDecorator(DataStream dataStream){
        this.dataStream = dataStream;
    }

    @Override
    public String read(){
        return dataStream.read();
    }

    @Override
    public void write(String data){
        dataStream.write(data);
    }

    @Override
    public String getDescription(){
        return dataStream.getDescription();
    }
}

