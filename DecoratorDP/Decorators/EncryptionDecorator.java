package Decorators;

import Components.DataStream;

public class EncryptionDecorator extends StreamDecorator {
    public EncryptionDecorator(DataStream dataStream){
        super(dataStream);
    }

    @Override
    public String read(){
        String encrypted = dataStream.read();
        return decrypt(encrypted);
    }

    @Override
    public void write(String data){
        String encrypted = encrypt(data);
        super.write(encrypted);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " (Encrypted)";
    }

    private String encrypt(String data){
        return "ENC[" + data + "]";
    }

    private String decrypt(String data){
        return data.replace("ENC[", "").replace("]", "");
    }
}

