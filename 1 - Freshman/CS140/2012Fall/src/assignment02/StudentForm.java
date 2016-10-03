package assignment02;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//Gabriel Ochoa
public class StudentForm {
    private JFrame frame = new JFrame("Student Entry Form");
    private JTextField firstNameEntry = new JTextField(20);
    private JTextField lastNameEntry = new JTextField(20);

    private JTextField yearEntry = new JTextField(4);
    private JTextField monthEntry = new JTextField(4);
    private JTextField dayEntry = new JTextField(4);
    // add entries for hour and minute hear
    private JTextField hourEntry = new JTextField(4);
    private JTextField minuteEntry = new JTextField(4);
    
    
    private JTextField quiz1Entry = new JTextField(5);
    private JTextField quiz2Entry = new JTextField(5);
    private JTextField quiz3Entry = new JTextField(5);
    private JTextField quiz4Entry = new JTextField(5);
    private JTextField quiz5Entry = new JTextField(5);
    

    // add entries for quiz 6 though 8 here
    private JTextField quiz6Entry = new JTextField(5);
    private JTextField quiz7Entry = new JTextField(5);
    private JTextField quiz8Entry = new JTextField(5);
   
    private JButton clearData = new JButton("Clear this Data");
    private JButton saveData = new JButton("Save this Data");

    private StudentForm(PrintWriter out) {
        frame.setLayout(new BorderLayout(3,3));
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(buildStudentEntryPanel(), BorderLayout.PAGE_START);
        frame.add(buildQuizEntryPanel());
        frame.add(buildButtonPanel(out), BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new ClosingListener(out));
        frame.setVisible(true);
    }

    private JPanel buildStudentEntryPanel() {
        JPanel panel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel datePanel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        namePanel.setLayout(new BoxLayout(namePanel,BoxLayout.LINE_AXIS));
        datePanel.setLayout(new BoxLayout(datePanel,BoxLayout.LINE_AXIS));
        panel.add(namePanel);
        panel.add(datePanel);
        namePanel.add(new JLabel(" First Name: ", JLabel.RIGHT));
        namePanel.add(firstNameEntry);
        namePanel.add(new JLabel(" Last Name: ", JLabel.RIGHT));
        namePanel.add(lastNameEntry);

        datePanel.add(new JLabel(" Birth Year: ", JLabel.RIGHT));
        datePanel.add(yearEntry);
        datePanel.add(new JLabel(" Month (0-11): ", JLabel.RIGHT));
        datePanel.add(monthEntry);
        datePanel.add(new JLabel(" Day (1-31): ", JLabel.RIGHT));
        datePanel.add(dayEntry);
        // add labels and fields to read the hour and minute of the birth
        datePanel.add(new JLabel(" Hour (0-23): ", JLabel.RIGHT));
        datePanel.add(monthEntry);
        datePanel.add(new JLabel(" Minute(0-59): ", JLabel.RIGHT));
        datePanel.add(dayEntry);
        
        return panel;       
    }

    private JPanel buildQuizEntryPanel() {
        JPanel panel = new JPanel();
        JPanel subPanel = new JPanel();
        panel.setLayout(new BorderLayout());
        subPanel.setLayout(new GridLayout(2,8));

        panel.add(new JLabel("Quiz Score Entry", JLabel.CENTER),
                BorderLayout.PAGE_START);
        panel.add(subPanel);

        subPanel.add(new JLabel("Quiz 1 ", JLabel.RIGHT));
        subPanel.add(quiz1Entry);
        subPanel.add(new JLabel("Quiz 2 ", JLabel.RIGHT));
        subPanel.add(quiz2Entry);
        subPanel.add(new JLabel("Quiz 3 ", JLabel.RIGHT));
        subPanel.add(quiz3Entry);
        subPanel.add(new JLabel("Quiz 4 ", JLabel.RIGHT));
        subPanel.add(quiz4Entry);
        subPanel.add(new JLabel("Quiz 5 ", JLabel.RIGHT));
        subPanel.add(quiz5Entry);
        
//REPLACE the following 6 labels with labels and fields for quizzes 6 though 8
        subPanel.add(new JLabel("Quiz 6 ", JLabel.RIGHT));
        subPanel.add(quiz6Entry);
        subPanel.add(new JLabel("Quiz 7 ", JLabel.RIGHT));
        subPanel.add(quiz7Entry);
        subPanel.add(new JLabel("Quiz 8 ", JLabel.RIGHT));
        subPanel.add(quiz8Entry);
        
        return panel;
    }

    private JPanel buildButtonPanel(PrintWriter out) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.add(clearData);
        clearData.addActionListener(new ClearListener());
        panel.add(saveData);
        saveData.addActionListener(new SaveListener(out));
        return panel;
    }
   
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FileOutputStream outfile;
                try {
                    outfile = new FileOutputStream("question4.txt", true);
                    PrintWriter output = new PrintWriter(outfile);
                    new StudentForm(output);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class ClosingListener extends WindowAdapter {
        PrintWriter out;

        public ClosingListener(PrintWriter out) {
            this.out= out;
        }

        @Override
        public void windowClosing(WindowEvent arg0) {
            if (frame == null) System.exit(0);
            int response = JOptionPane.showConfirmDialog(frame,
                    "Do you want to exit the program?",
                    "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION) {
                if (out != null) out.close();
                System.exit(0);
            }
        }
    }
   
    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            firstNameEntry.setText("");
            //clear all the other fields
            lastNameEntry.setText("");
            yearEntry.setText("");
            monthEntry.setText("");
            dayEntry.setText("");
            hourEntry.setText(""); 
            minuteEntry.setText("");
        
            
        }
    }
    private class SaveListener implements ActionListener {
        PrintWriter out;
        public SaveListener(PrintWriter out) {
            this.out = out;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            firstNameEntry.getText();
            String name = lastNameEntry.getText() + ", " +firstNameEntry.getText();
            try {
                int year = Integer.parseInt(yearEntry.getText().trim());
                int month = Integer.parseInt(monthEntry.getText().trim());
                int day = Integer.parseInt(dayEntry.getText().trim());
                int hour = Integer.parseInt(hourEntry.getText().trim());
                int minute = Integer.parseInt(minuteEntry.getText().trim());
                // add code for quizzes 6 through 8
                int quiz1 = Integer.parseInt(quiz1Entry.getText().trim());
                int quiz2 = Integer.parseInt(quiz2Entry.getText().trim());
                int quiz3 = Integer.parseInt(quiz3Entry.getText().trim());
                int quiz4 = Integer.parseInt(quiz4Entry.getText().trim());
                int quiz5 = Integer.parseInt(quiz5Entry.getText().trim());
                

                int quiz6 = Integer.parseInt(quiz1Entry.getText().trim());
                int quiz7 = Integer.parseInt(quiz2Entry.getText().trim());
                int quiz8 = Integer.parseInt(quiz3Entry.getText().trim());
                
                // add code for quizzes 6 through 8
                Student temp = new Student(name,new DOB(year,month,day, hour, minute),0);
                temp.addQuiz(quiz1);
                temp.addQuiz(quiz2);
                temp.addQuiz(quiz3);
                temp.addQuiz(quiz4);
                temp.addQuiz(quiz5);
                // add the other scores here
                StringBuilder bldr = new StringBuilder(temp.getName());
                bldr.append(" born: ");
                bldr.append(temp.printDateTime());
                bldr.append("\nQuiz grades: ");
                bldr.append(quiz1);
                bldr.append(", ");
                bldr.append(quiz2);
                bldr.append(", ");
                bldr.append(quiz3);
                bldr.append(", ");
                bldr.append(quiz4);
                bldr.append(", ");
                bldr.append(quiz5);
                // add the other quiz scores here
               
                bldr.append(". Average =");
                bldr.append(temp.getAverageScore());
                out.println(bldr);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog (frame,
                        "A number is missing, or there is\n" +
                        "an error in one of the numbers.\n" +
                        "Please check them",
                        "Check the numbers", JOptionPane.OK_OPTION);
            }
        }
    }
}