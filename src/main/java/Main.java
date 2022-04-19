import entity.Printer;
import entity.ProductEntity;
import org.apache.log4j.Logger;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public Main() throws InvocationTargetException, InstantiationException, IllegalAccessException {
    }

    public static void main(String[] args) {
            String data = "Hello World!";
            Printer printer = new Printer();
//            Printer p= ()-> System.out.println(data);
//            printer.print(p);
        }
    // Create a Logger
    Logger logger  = Logger.getLogger(Main.class.getName());

        Constructor[] constructors = ProductEntity.class.getDeclaredConstructors();
        ProductEntity product = (ProductEntity) constructors[0].newInstance();
        //Field fieldfirst = product.getClass().getDeclaredField();
        Field[] fields = product.getClass().getDeclaredFields();
       // Method m = product.getClass().getDeclaredMethod();


}

