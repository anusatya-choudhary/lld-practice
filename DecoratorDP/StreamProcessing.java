import Components.*;
import Decorators.*;

public class StreamProcessing {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo ===\n");
        
        // Demo 1: Basic Streams (No Decorators)
        System.out.println("--- Demo 1: Basic Streams ---");
        Components.DataStream memoryStream = new MemoryStream("myData");
        Components.DataStream fileStream = new FileStream("example.txt");
        Components.DataStream networkStream = new NetworkStream("https://api.example.com");
        
        System.out.println("Memory Stream:");
        System.out.println("  Description: " + memoryStream.getDescription());
        memoryStream.write("Hello World");
        System.out.println("  Read: " + memoryStream.read());
        System.out.println();
        
        // Demo 2: Single Decorator
        System.out.println("--- Demo 2: Single Decorator ---");
        Components.DataStream compressedFile = new CompressionDecorator(fileStream);
        System.out.println("Compressed File Stream:");
        System.out.println("  Description: " + compressedFile.getDescription());
        compressedFile.write("Important Data");
        System.out.println("  Read: " + compressedFile.read());
        System.out.println();
        
        // Demo 3: Multiple Decorators Chained
        System.out.println("--- Demo 3: Multiple Decorators (Encrypted + Compressed) ---");
        Components.DataStream secureStream = new EncryptionDecorator(
            new CompressionDecorator(
                new MemoryStream("secureData")
            )
        );
        System.out.println("Secure Stream Chain:");
        System.out.println("  Description: " + secureStream.getDescription());
        secureStream.write("Sensitive Information");
        System.out.println("  Read: " + secureStream.read());
        System.out.println();
        
        // Demo 4: Different Decorator Order
        System.out.println("--- Demo 4: Different Decorator Order (Compressed + Encrypted) ---");
        Components.DataStream differentOrder = new CompressionDecorator(
            new EncryptionDecorator(
                new MemoryStream("data")
            )
        );
        System.out.println("Different Order Chain:");
        System.out.println("  Description: " + differentOrder.getDescription());
        differentOrder.write("Test Data");
        System.out.println("  Read: " + differentOrder.read());
        System.out.println();
        
        // Demo 5: All Decorators Combined
        System.out.println("--- Demo 5: All Decorators Combined ---");
        Components.DataStream fullyDecorated = new CachingDecorator(
            new BufferingDecorator(
                new EncryptionDecorator(
                    new CompressionDecorator(
                        new NetworkStream("https://api.example.com")
                    )
                )
            )
        );
        System.out.println("Fully Decorated Network Stream:");
        System.out.println("  Description: " + fullyDecorated.getDescription());
        fullyDecorated.write("Complete Pipeline Data");
        System.out.println("  Read: " + fullyDecorated.read());
        System.out.println();
        
        // Demo 6: Different Base Streams with Same Decorators
        System.out.println("--- Demo 6: Same Decorators, Different Base Streams ---");
        Components.DataStream decoratedFile = new EncryptionDecorator(
            new CompressionDecorator(
                new FileStream("secret.txt")
            )
        );
        Components.DataStream decoratedNetwork = new EncryptionDecorator(
            new CompressionDecorator(
                new NetworkStream("https://secure.com")
            )
        );
        
        System.out.println("Decorated File Stream:");
        System.out.println("  Description: " + decoratedFile.getDescription());
        decoratedFile.write("File Data");
        System.out.println();
        
        System.out.println("Decorated Network Stream:");
        System.out.println("  Description: " + decoratedNetwork.getDescription());
        decoratedNetwork.write("Network Data");
        System.out.println();
        
        System.out.println("=== Demo Complete ===");
    }
}
