public class WindowsCheckbox implements Checkbox {
    @Override
    public void render(){
        System.out.println("Rendering a Windows checkbox...");
    }

    @Override
    public void onClick(){
        System.out.println("Windows checkbox clicked...");
    }
}