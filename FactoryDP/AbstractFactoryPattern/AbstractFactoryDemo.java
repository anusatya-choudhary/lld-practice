public class AbstractFactoryDemo {
    private Button button;
    private Checkbox checkbox;

    public AbstractFactoryDemo(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }

    public void onClick() {
        button.onClick();
        checkbox.onClick();
    }

    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo ===\n");
        
        System.out.println("--- Windows UI ---");
        GUIFactory windowsFactory = new WindowsFactory();
        AbstractFactoryDemo windowsApp = new AbstractFactoryDemo(windowsFactory);
        System.out.println("Windows App initialized with Windows factory");
        windowsApp.render();
        windowsApp.onClick();

        System.out.println("\n--- Mac UI ---");
        GUIFactory macFactory = new MacFactory();
        AbstractFactoryDemo macApp = new AbstractFactoryDemo(macFactory);
        System.out.println("Mac App initialized with Mac factory");
        macApp.render();
        macApp.onClick();

    }
}
