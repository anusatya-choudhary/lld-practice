package lld.MementoDP;

public class TextEditor {
    private String content;

    public TextEditor() {
        this.content = "";
    }

    public void write(String text) {
        this.content += " " + text;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento){
        this.content = memento.getContent();
    }

    public String getContent() {
        return content;
    }
}
