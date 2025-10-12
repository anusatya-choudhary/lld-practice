package lld.MementoDP;

// Each text editor obj will have a caretaker obj
// This caretaker obj will manage the state (snapshots) of its text editor obj

// TextEditor is the Originator (whose state we want to save)
// Caretaker is the Caretaker
// Memento is the Memento (class which is used to save the state of the Originator)

public class MementoPatternMain {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        caretaker.saveSnapshot(textEditor);

        textEditor.write("Hello everyone.");
        caretaker.saveSnapshot(textEditor);

        textEditor.write("This is an example of memento pattern.");
        caretaker.saveSnapshot(textEditor);

        textEditor.write("Lets test the memento pattern.");
   
        System.out.println("Current content: " + textEditor.getContent());

        caretaker.restoreSnapshot(textEditor);
        System.out.println("Restored content: " + textEditor.getContent());

        caretaker.restoreSnapshot(textEditor);
        System.out.println("Restored content: " + textEditor.getContent());

        caretaker.restoreSnapshot(textEditor);
        System.out.println("Restored content: " + textEditor.getContent());
    }
}
