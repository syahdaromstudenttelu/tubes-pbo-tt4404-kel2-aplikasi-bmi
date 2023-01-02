package swing_frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMISwingFrame extends JFrame implements ActionListener {
  private JTextField bmiCalcHeightTF;
  private JTextField bmiCalcMassTF;
  private JTextField bmiCalcResultTF;
  private JTextField bmiWeightStatusTF;

  private String getWeightStatus(double bmiResult) {
    if (bmiResult < 18.5) {
      return "Berat terlalu rendah";
    } else if (bmiResult < 24.9) {
      return "Berat normal";
    } else if (bmiResult < 29.9) {
      return "Berat melebihi berat normal";
    } else {
      return "Obesitas";
    }
  }

  private JPanel identitySection() {
    JPanel identityPanel = new JPanel();
    identityPanel.setLayout(new BoxLayout(identityPanel, BoxLayout.Y_AXIS));
    identityPanel.setBackground(null);

    JLabel projectNameLabel = new JLabel();
    projectNameLabel.setBorder(new EmptyBorder(10, 10, 0, 10));
    projectNameLabel.setText("Kalkulator BMI");
    projectNameLabel.setFont(new Font("Inter", Font.BOLD, 32));
    projectNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel projectTitleLabel = new JLabel();
    projectTitleLabel.setBorder(new EmptyBorder(10, 10, 20, 10));
    projectTitleLabel.setText("Tugas Besar PBO | TT-44-04 | Kelompok 2");
    projectTitleLabel.setFont(new Font("Inter", Font.BOLD, 16));
    projectTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    JPanel projectGroupPanel = new JPanel();
    projectGroupPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 0));
    projectGroupPanel.setBackground(null);

    JLabel projectGroupLabel = new JLabel();
    projectGroupLabel.setText("Nama anggota:");
    projectGroupLabel.setFont(new Font("Inter", Font.BOLD, 16));
    projectGroupLabel.setVerticalTextPosition(JLabel.TOP);

    JPanel projectGroupNamesPanel = new JPanel();
    projectGroupNamesPanel.setLayout(new BoxLayout(projectGroupNamesPanel, BoxLayout.Y_AXIS));
    projectGroupNamesPanel.setBackground(null);

    JLabel groupName1Label = new JLabel();
    groupName1Label.setText("- Faisal Akbar Tasmara (1101190391)");
    groupName1Label.setFont(new Font("Inter", Font.BOLD, 16));

    JLabel groupName2Label = new JLabel();
    groupName2Label.setText("- Syahda Romansyah (1101190402)");
    groupName2Label.setFont(new Font("Inter", Font.BOLD, 16));

    JLabel groupName3Label = new JLabel();
    groupName3Label.setText("- Sedli Irfangi (1101202557)");
    groupName3Label.setFont(new Font("Inter", Font.BOLD, 16));

    projectGroupNamesPanel.add(groupName1Label);
    projectGroupNamesPanel.add(groupName2Label);
    projectGroupNamesPanel.add(groupName3Label);

    projectGroupPanel.add(projectGroupLabel);
    projectGroupPanel.add(projectGroupNamesPanel);

    identityPanel.add(projectNameLabel);
    identityPanel.add(projectTitleLabel);
    identityPanel.add(projectGroupPanel);

    return identityPanel;
  }

  private JPanel bmiCalcSection() {
    JPanel bmiCalcPanel = new JPanel();
    bmiCalcPanel.setLayout(new BoxLayout(bmiCalcPanel, BoxLayout.Y_AXIS));
    bmiCalcPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
    bmiCalcPanel.setBackground(null);

    JPanel bmiCalcHeightPanel = new JPanel();
    bmiCalcHeightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
    bmiCalcHeightPanel.setBackground(null);

    JLabel bmiCalcHeightLabel = new JLabel();
    bmiCalcHeightLabel.setText("Masukan tinggi badan Anda (cm):");
    bmiCalcHeightLabel.setFont(new Font("Inter", Font.BOLD, 16));

    this.bmiCalcHeightTF = new JTextField();
    this.bmiCalcHeightTF.addActionListener(this);
    this.bmiCalcHeightTF.setFont(new Font("Inter", Font.BOLD, 16));
    this.bmiCalcHeightTF.setColumns(8);
    this.bmiCalcHeightTF.setText("0");

    bmiCalcHeightPanel.add(bmiCalcHeightLabel);
    bmiCalcHeightPanel.add(this.bmiCalcHeightTF);

    JPanel bmiCalcWeightPanel = new JPanel();
    bmiCalcWeightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 18, 0));
    bmiCalcWeightPanel.setBackground(null);

    JLabel bmiCalcWeightLabel = new JLabel();
    bmiCalcWeightLabel.setText("Masukan berat badan Anda (kg):");
    bmiCalcWeightLabel.setFont(new Font("Inter", Font.BOLD, 16));

    this.bmiCalcMassTF = new JTextField();
    this.bmiCalcMassTF.addActionListener(this);
    this.bmiCalcMassTF.setFont(new Font("Inter", Font.BOLD, 16));
    this.bmiCalcMassTF.setColumns(8);
    this.bmiCalcMassTF.setText("0");

    bmiCalcWeightPanel.add(bmiCalcWeightLabel);
    bmiCalcWeightPanel.add(this.bmiCalcMassTF);

    bmiCalcPanel.add(bmiCalcHeightPanel);
    bmiCalcPanel.add(bmiCalcWeightPanel);

    return bmiCalcPanel;
  }

  private JPanel bmiResultSection() {
    JPanel bmiResultPanel = new JPanel();
    bmiResultPanel.setLayout(new BoxLayout(bmiResultPanel, BoxLayout.Y_AXIS));
    bmiResultPanel.setBackground(null);

    JPanel bmiCalcResultPanel = new JPanel();
    bmiCalcResultPanel.setBackground(null);

    JLabel bmiCalcResultLabel = new JLabel();
    bmiCalcResultLabel.setText("BMI Anda adalah");
    bmiCalcResultLabel.setFont(new Font("Inter", Font.BOLD, 16));

    this.bmiCalcResultTF = new JTextField();
    this.bmiCalcResultTF.setBorder(null);
    this.bmiCalcResultTF.setEditable(false);
    this.bmiCalcResultTF.setFont(new Font("Inter", Font.BOLD, 16));
    this.bmiCalcResultTF.setColumns(4);
    this.bmiCalcResultTF.setText("0");

    bmiCalcResultPanel.add(bmiCalcResultLabel);
    bmiCalcResultPanel.add(this.bmiCalcResultTF);

    JPanel bmiWeightStatusPanel = new JPanel();
    bmiWeightStatusPanel.setBackground(null);

    JLabel bmiWeightStatusLabel = new JLabel();
    bmiWeightStatusLabel.setText("Status berat Anda:");
    bmiWeightStatusLabel.setFont(new Font("Inter", Font.BOLD, 16));

    this.bmiWeightStatusTF = new JTextField();
    this.bmiWeightStatusTF.setBorder(new EtchedBorder());
    this.bmiWeightStatusTF.setEditable(false);
    this.bmiWeightStatusTF.setFont(new Font("Inter", Font.BOLD, 16));
    this.bmiWeightStatusTF.setColumns(15);
    this.bmiWeightStatusTF.setText("");

    bmiWeightStatusPanel.add(bmiWeightStatusLabel);
    bmiWeightStatusPanel.add(this.bmiWeightStatusTF);

    bmiResultPanel.add(bmiCalcResultPanel);
    bmiResultPanel.add(bmiWeightStatusPanel);

    return bmiResultPanel;
  }

  public BMISwingFrame() {
    this.setTitle("Kalkulator BMI");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.getContentPane().setBackground(new Color(0xfde68a));

    this.getContentPane().add(this.identitySection());
    this.getContentPane().add(this.bmiCalcSection());
    this.getContentPane().add(this.bmiResultSection());

    this.setResizable(false);
    this.pack();
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      double heightInputValue = Math.pow(Double.parseDouble(this.bmiCalcHeightTF.getText()) / 100, 2.0);
      double weightInputValue = Double.parseDouble(this.bmiCalcMassTF.getText());

      if (heightInputValue < 1.30 || weightInputValue < 10.0) {
        throw new NumberFormatException();
      }

      double bmiResult = Math.round(weightInputValue / heightInputValue * 10.0) / 10.0;

      this.bmiCalcResultTF.setText(String.valueOf(bmiResult));
      this.bmiWeightStatusTF.setText(this.getWeightStatus(bmiResult));
    } catch (NumberFormatException error) {
      this.bmiCalcHeightTF.setText("0");
      this.bmiCalcMassTF.setText("0");
      this.bmiCalcResultTF.setText("0");
      this.bmiWeightStatusTF.setText("Masukan tidak valid");
    }
  }
}
