package buttons;

import models.*;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WritePublicDiaryButton extends JButton {
  private List<Diary> diaries;
  private Switch switchButton;
  private JTextField titleTextField;
  private JTextArea contentTextArea;
  private JPanel publicDiaryPanel;


  public WritePublicDiaryButton(List<Diary> diaries, Switch switchButton) {
    this.diaries = diaries;
    this.switchButton = switchButton;
    this.setText("공유일기 쓰기");

    this.addActionListener(event -> {
      publicDiaryPanel = getParentPanel();

      cleanDisplay(publicDiaryPanel);

      JPanel contentPanel = creatTextsField(publicDiaryPanel);

      addSaveButton(contentPanel);

      publicDiaryPanel.setVisible(true);
    });
  }

  private JPanel getParentPanel() {
    JPanel publicDiaryPanel = (JPanel) this.getParent().getParent();
    return publicDiaryPanel;
  }

  private JPanel creatTextsField(JPanel publicDiaryPanel) {
    //새로운 컨텐츠 패널을 연다.
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new BorderLayout());
    publicDiaryPanel.add(contentPanel,BorderLayout.CENTER);

    //텍스트 필드와 텍스트 에어리어를 연다
    titleTextField = new JTextField(10);
    titleTextField.setText("오늘 하루를 대변할 근사한 제목을 입력해주세요.");
    contentTextArea = new JTextArea(30,10);
    contentTextArea.setText("오늘 하루를 설명해보세요!");

    contentPanel.add(titleTextField,BorderLayout.PAGE_START);
    contentPanel.add(contentTextArea,BorderLayout.CENTER);
    return contentPanel;
  }

  private void cleanDisplay(JPanel publicDiaryPanel) {
    publicDiaryPanel.removeAll();
    publicDiaryPanel.setVisible(false);
    publicDiaryPanel.setLayout(new BorderLayout());
  }

  private void addSaveButton(JPanel contentPanel) {
    JButton saveButton = new JButton("저장하기");
    contentPanel.add(saveButton,BorderLayout.PAGE_END);

    saveButton.addActionListener(event -> {
      //주어진 것 텍스트들을 수정불가상태가됨
      titleTextField.setEditable(false);
      contentTextArea.setEditable(false);
      //텍스트필에드에서 얻어진 텍스트가 다이어리로 전달되어 저장됨
      String title = titleTextField.getText();
      String content = contentTextArea.getText();
      Diary diary = new Diary(title,content);
      diaries.add(diary);
      //갱신스위치 켜줌
      switchButton.ON();

    });
  }
}
