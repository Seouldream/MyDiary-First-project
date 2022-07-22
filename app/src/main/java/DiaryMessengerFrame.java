import models.*;
import panels.*;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

public class DiaryMessengerFrame {
  private JFrame mainFrame;
  private JPanel contentPanel = new JPanel();
  private JButton publicDiaryButton;
  private JButton privateDiaryButton;
  private JButton messengerButton;
  private Switch switchButton = new Switch();
  private List<Diary> diaries = new ArrayList<>();

  public static void main(String[] args) {
    DiaryMessengerFrame application = new DiaryMessengerFrame();
    application.run();
  }
  private void run() {
    Account account = new Account();

    setFrameSetting();

    activatePublicDiaryPanel();

    activatePrivateDiaryPanel();

    activateMessengerPanel();

    if(switchButton.state().equals("ON")) {

    }


    mainFrame.add(contentPanel,BorderLayout.CENTER);
    mainFrame.setVisible(true);
  }

  private void activatePublicDiaryPanel() {
    publicDiaryButton.addActionListener(event -> {

      showContentPanel();
      mainFrame.add(contentPanel,BorderLayout.CENTER);
    });
  }

  private void activatePrivateDiaryPanel() {
    privateDiaryButton.addActionListener(event -> {
      contentPanel = new privateDiaryPanel();
    });
  }

  private void activateMessengerPanel() {
    messengerButton.addActionListener(event -> {
      contentPanel = new messengerPanel();
    });
  }

  private JFrame setFrameSetting() {
    mainFrame = new JFrame("너와 나의 다이어리 메신저 룰루!");
    mainFrame.setSize(700,700);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setLayout(new BorderLayout());

    JPanel headPanel = new JPanel();
    publicDiaryButton = new JButton("공유일기 쓰러 가기");
    privateDiaryButton = new JButton("나만을 위한 비밀일기 쓰러 가기");
    messengerButton = new JButton("메신저함 가기");

    headPanel.add(publicDiaryButton);
    headPanel.add(privateDiaryButton);
    headPanel.add(messengerButton);
    mainFrame.add(headPanel,BorderLayout.PAGE_START);
    return mainFrame;
  }

  private void showContentPanel() {
    contentPanel.removeAll();
    contentPanel.setVisible(false);
    contentPanel = new publicDiaryPanel(diaries,switchButton);
    contentPanel.setVisible(true);
  }
}
