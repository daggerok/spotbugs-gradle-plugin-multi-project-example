package daggerok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class App {
  private static final Logger log = LoggerFactory.getLogger(App.class);
  public static void main(String[] args) {
    List<Object> list = new ArrayList();
    list.add(new Integer(1234));
    System.out.print(list);
    log.info("yo!");
  }
}
