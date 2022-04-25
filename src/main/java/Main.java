import entity.FoodProductEntity;
import entity.ProductEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.implement.ProductServiceImp;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  static final Logger LOGGER = LogManager.getLogger(Main.class);

  public static void main(String[] args) throws Exception {
    readFile();


    ArrayList<ProductEntity> entities = new ArrayList<>();
    FoodProductEntity product1 = new FoodProductEntity();
    product1.setId(1L);
    product1.setPrice(1.5);
    product1.setDescription("Rice");
    FoodProductEntity product2 = new FoodProductEntity();
    product2.setId(2L);
    product2.setPrice(1.05);
    product2.setDescription("Spaghetti");
    entities.add(product1);
    entities.add(product2);
    //Using logger
    ProductServiceImp productServiceImp = new ProductServiceImp();
    productServiceImp.getAllProducts(entities);
    //Using lambda expression
    //Print products with id equal to or greater than 1
    entities.forEach(d1 -> {
      if (d1.getId() >= 1) d1.printProducts(d1);
    });

    //Using reflexion with logger
    Constructor[] constructors = FoodProductEntity.class.getDeclaredConstructors();
    Object product = constructors[3].newInstance();
    Field[] fields = product.getClass().getDeclaredFields();
    Arrays.stream(fields).forEach(f -> LOGGER.info("Reflexion info:" + f.getType()));
    Method[] methods = product.getClass().getDeclaredMethods();
    Arrays.stream(methods).forEach(m -> LOGGER.info("Reflexion info:" + m.getName()));
  }

  public static void readFile() {

    //Name of the file to be read
    String fileName = "src/main/resources/Article";
    try {
      //Create object of FileReader
      FileReader inputFile = new FileReader(fileName);

      //Instantiate the BufferedReader Class
      BufferedReader bufferReader = new BufferedReader(inputFile);

      //Variable to hold the one line data
      String line;

      // Read file line by line and add to array
      ArrayList<String> listWords = new ArrayList<>();
      TreeMap<String, Integer> mapWords = new TreeMap<>();
      while ((line = bufferReader.readLine()) != null) {
        String[] words = line.split("\\W+");
        for (String w : words
        ) {
          if (!mapWords.containsKey(w)) {
            mapWords.put(w, 1);

          } else {
            Integer value = mapWords.get(w);
            value++;
            mapWords.replace(w, value);
          }
        }
      }
      //Close the buffer reader
      bufferReader.close();
      //Create a file with for the answers
      File file = new File("src/main/resources/wordsNumber.txt");
      //Create object of FileWriter
      FileWriter fw = new FileWriter("wordsNumber.txt");

      //Order
      Map<String, Integer> sortedMap = sortWordsByValue(mapWords);
      //Write in the file
      fw.write(String.valueOf(sortedMap.entrySet()));
      fw.close();
    } catch (Exception e) {
      System.out.println("Error while reading file line by line:" + e.getMessage());
    }

  }

  public static Map<String, Integer> sortWordsByValue(final Map<String, Integer> mapWords) {

    return mapWords.entrySet()
            .stream()
            .sorted((e2, e1) -> Integer.compare(e2.getValue(), e1.getValue()))
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e1, LinkedHashMap::new));

  }

  /**
   * The HelloWorldApp class implements an application that
   * simply prints "Hello World!" to standard output.
   */
//  class HelloWorldApp {
//    public static void main(String[] args) {
//      System.out.println("Hello World! " + args[0] + " " + args[1] + "!"); // print the arguments string.
//    }
//  }
}

