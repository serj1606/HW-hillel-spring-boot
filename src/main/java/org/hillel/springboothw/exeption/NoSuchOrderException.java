package org.hillel.springboothw.exeption;

public class NoSuchOrderException extends RuntimeException {

  public NoSuchOrderException(String message) {
    super(message);
  }
}
