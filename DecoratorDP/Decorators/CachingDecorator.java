package Decorators;

import Components.DataStream;

public class CachingDecorator extends StreamDecorator {
    public CachingDecorator(DataStream dataStream){
        super(dataStream);
    }

    @Override
    public String read(){
        String cached = dataStream.read();
        return uncache(cached);
    }

    @Override
    public void write(String data){
        String cached = cache(data);
        super.write(cached);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " (Cached)";
    }

    private String cache(String data){
        return "CACHE[" + data + "]";
    }

    private String uncache(String data){
        return data.replace("CACHE[", "").replace("]", "");
    }
}

