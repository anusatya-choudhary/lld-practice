package lld.MementoDP;

import java.util.Stack;

// Caretaker class : Used to manage state (snapshots) of the Originator

public class Caretaker {
    private final Stack<Memento> mementos = new Stack<>();

    public void saveSnapshot(TextEditor textEditor) {
        Memento memento = textEditor.save();
        mementos.push(memento);
    }

    public void restoreSnapshot(TextEditor textEditor) {
        if(mementos.isEmpty()) {
            throw new IllegalStateException("No snapshots to restore");
        }
        Memento latestMemento = mementos.pop();
        textEditor.restore(latestMemento);
    }
}
