package bitcamp.util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {

  private Scanner scanner;

  public Prompt() {
    scanner = new Scanner(System.in);
  }

  public Prompt(InputStream in) {
    scanner = new Scanner(in);
  }

  public String inputString(String title, Object... args) {
    System.out.printf(title, args);
    return scanner.nextLine();
  }

  public int inputInt(String title, Object... args) {
    return Integer.parseInt(inputString(title, args));
  }

  public void close() {
    scanner.close();
  }
}
