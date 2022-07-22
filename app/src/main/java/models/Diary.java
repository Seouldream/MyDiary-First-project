package models;

import java.util.*;

public class Diary {
  private static String PUBLISHED =  "PUBLISHED";
  private static String DELETED = "DELETED";
  private String title;
  private String content;
  private String id;
  private String state;

  public Diary(String title, String content) {
    this.title = title;
    this.content = content;
    this.id = String.valueOf(UUID.randomUUID());
    this.state = Diary.PUBLISHED;
  }

  public String title() {
    return title;
  }

  public String content() {
    return content;
  }

  public String state() {
    return state;
  }

  public void delete() {
    state = Diary.DELETED;
  }

  public String id() {
    return id;
  }
}
