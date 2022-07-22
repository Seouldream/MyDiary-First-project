package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
  @BeforeEach
  void Diary() {
    Diary diary = new Diary("제목","내용");
  }
  @Test
  void title(){
    Diary diary = new Diary("제목","내용");
    assertEquals("제목",diary.title());
  }

  @Test
  void content(){
    Diary diary = new Diary("제목","내용");
    assertEquals("내용",diary.content());
  }

  @Test
  void state(){
    Diary diary = new Diary("제목","내용");
    assertEquals("PUBLISHED",diary.state());
    diary.delete();
    assertEquals("DELETED",diary.state());
  }

  @Test
  void id(){
    Diary diary = new Diary("제목","내용");
    assertEquals("내용",diary.id());
  }
}