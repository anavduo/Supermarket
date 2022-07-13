import entity.EmployeeEntity;
import entity.FoodProductEntity;
import entity.ProductEntity;
import main.java.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import service.implement.ProductServiceImp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  static final Logger LOGGER = LogManager.getLogger(Main.class);

  public static void main(String[] args) throws Exception {
    //MyBatis
    Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession session = sqlSessionFactory.openSession();

    //Create a new student object
    Student student = new Student("Mohammad","It", 80, 984803322, "Mohammad@gmail.com" );

    //Insert student data
    session.insert("Student.insert", student);
    System.out.println("record inserted successfully");
    session.commit();
    session.close();



//    //Dom parsing xml
//
//        //Get Document Builder
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
//        // Load the input XML document, parse it and return an instance of the
//        // Document class.
//        Document document = builder.parse(new File("Employees.xml"));
//
//        List<EmployeeEntity> employees = new ArrayList<>();
//        NodeList nodeList = document.getDocumentElement().getChildNodes();
//        for (int i = 0; i < nodeList.getLength(); i++) {
//          Node node = nodeList.item(i);
//
//          if (node.getNodeType() == Node.ELEMENT_NODE) {
//            Element elem = (Element) node;
//
//            // Get the value of the ID attribute.
//            String ID = node.getAttributes().getNamedItem("ID").getNodeValue();
//
//            // Get the value of all sub-elements.
//            String firstname = elem.getElementsByTagName("Firstname")
//                    .item(0).getChildNodes().item(0).getNodeValue();
//
//            String lastname = elem.getElementsByTagName("Lastname").item(0)
//                    .getChildNodes().item(0).getNodeValue();
//
//            Integer age = Integer.parseInt(elem.getElementsByTagName("Age")
//                    .item(0).getChildNodes().item(0).getNodeValue());
//
//            Double salary = Double.parseDouble(elem.getElementsByTagName("Salary")
//                    .item(0).getChildNodes().item(0).getNodeValue());
//
//            employees.add(new EmployeeEntity(ID, firstname, lastname, age, salary));
//          }
//        }
//
//        // Using logger and lambda to print all employees.
//           employees.forEach(e -> LOGGER.info("Info employee Firstname: "
//                   + e.getFirstname()+ ", Lastname: " + e.getLastname()+
//                   ", Age: "+ e.getAge()+", Salary: " + e.getSalary()));
//
//
//    //Using multithreading
//    HelloWorldApp hwapp = new HelloWorldApp();
//    hwapp.start();
//    hwapp.run(args);
//
//    //Name of the file to be read
//    String fileName = "src/main/resources/Article";
//    //Call the function to count words the information will be written in wordsNumber.text
//    countWords(fileName);
//
//
//    ArrayList<ProductEntity> entities = new ArrayList<>();
//    FoodProductEntity product1 = new FoodProductEntity();
//    product1.setId(1L);
//    product1.setPrice(1.5);
//    product1.setDescription("Rice");
//    FoodProductEntity product2 = new FoodProductEntity();
//    product2.setId(2L);
//    product2.setPrice(1.05);
//    product2.setDescription("Spaghetti");
//    entities.add(product1);
//    entities.add(product2);
//    //Using logger
//    ProductServiceImp productServiceImp = new ProductServiceImp();
//    productServiceImp.getAllProducts(entities);
//    //Using lambda expression
//    //Print products with id equal to or greater than 1
//    entities.forEach(d1 -> {
//      if (d1.getId() >= 1) d1.printProducts(d1);
//    });
//
//    //Using reflexion with logger
//    Constructor[] constructors = FoodProductEntity.class.getDeclaredConstructors();
//    Object product = constructors[3].newInstance();
//    Field[] fields = product.getClass().getDeclaredFields();
//    Arrays.stream(fields).forEach(f -> LOGGER.info("Reflexion info:" + f.getType()));
//    Method[] methods = product.getClass().getDeclaredMethods();
//    Arrays.stream(methods).forEach(m -> LOGGER.info("Reflexion info:" + m.getName()));
//  }
//
//  public static void countWords(String fileName) {
//    TreeMap<String, Integer> mapWords = new TreeMap<>();
//    readFile(fileName, mapWords);
//    writeFile(fileName,mapWords);
//  }
//  public static void readFile(String fileName,TreeMap<String, Integer> mapWords) {
//    try {
//      //Create object of FileReader
//      FileReader inputFile = new FileReader(fileName);
//      //Instantiate the BufferedReader Class
//      BufferedReader bufferReader = new BufferedReader(inputFile);
//      //Variable to hold the one line data
//      String line;
//
//      // Read file line by line and add to array
//
//      while ((line = bufferReader.readLine()) != null) {
//        String[] words = line.split("\\W+");
//        for (String w : words
//        ) {
//          if (!mapWords.containsKey(w)) {
//            mapWords.put(w, 1);
//          } else {
//            Integer value = mapWords.get(w);
//            value++;
//            mapWords.replace(w, value);
//          }
//        }
//      }
//      //Close the buffer reader
//      bufferReader.close();
//
//    } catch (Exception e) {
//      System.out.println("Error while reading file line by line:" + e.getMessage());
//    }
//  }
//  public static void writeFile(String fileName,TreeMap<String, Integer> mapWords) {
//    try {
//    //Create a file with for the answers
//    File file = new File("src/main/resources/wordsNumber.txt");
//    //Create object of FileWriter
//    FileWriter fw = new FileWriter("wordsNumber.txt");
//    //Order
//    Map<String, Integer> sortedMap = sortWordsByValue(mapWords);
//    //Write in the file
//    fw.write(String.valueOf(sortedMap.entrySet()));
//    fw.close();
//    } catch (Exception e) {
//      System.out.println("Error while writing the file :" + e.getMessage());
//    }
//  }
//
//  public static Map<String, Integer> sortWordsByValue(final Map<String, Integer> mapWords) {
//
//    return mapWords.entrySet()
//            .stream()
//            .sorted((e2, e1) -> Integer.compare(e2.getValue(), e1.getValue()))
//            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e1, LinkedHashMap::new));
//}
//
//
//
//    /**
//     * The HelloWorldApp class implements an application that
//     * simply prints "Hello World!" to standard output.
//     */
//  public static class HelloWorldApp extends Thread{
//    public void run(String[] args) {
//      System.out.println("Hello World! " + args[0] + " " + args[1] + "!"); // print the arguments string.
//    }
  }
}

