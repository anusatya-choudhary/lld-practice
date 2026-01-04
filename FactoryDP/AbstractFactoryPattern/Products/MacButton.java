public class MacButton implements Button {
    @Override
    public void render(){
        System.out.println("Rendering a Mac button...");
    }

    @Override
    public void onClick(){
        System.out.println("Mac button clicked...");
    }
}
