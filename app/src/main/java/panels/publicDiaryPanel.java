package panels;

import buttons.*;
import models.*;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class publicDiaryPanel extends JPanel {
  public publicDiaryPanel(List<Diary> diaries, Switch switchButton) {
    this.setLayout(new BorderLayout());

    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new GridLayout(15,5));
    this.add(contentPanel);

    JPanel underBarPanel = new JPanel();
    underBarPanel.setLayout(new BorderLayout());

    JButton writePublicDiaryButton = new WritePublicDiaryButton(diaries,switchButton);
    this.add(underBarPanel,BorderLayout.PAGE_END);
    underBarPanel.add(writePublicDiaryButton,BorderLayout.EAST);

    this.setVisible(true);



  }
}
