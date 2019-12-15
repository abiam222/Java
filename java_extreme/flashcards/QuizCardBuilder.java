import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;
    
    public static void main (String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }
    public void go() {
       //build and display gui 

       frame = new JFrame("Quiz Card Builder");
       JPanel mainPanel = new JPanel();
       Font bigFont = new Font("saserif", Font.BOLD, 24);
       question = new JTextArea(6,20);
       question.setLineWrap(true);
       question.setWrapStyleWord(true);
       question.setFont(bigFont);

       JScrollPane qScroller = new JScrollPane(question);
       qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

       answer = new JTextArea(6,20);
       answer.setLineWrap(true);
       answer.setWrapStyleWord(true);
       answer.setFont(bigFont);

       JScrollPane aScroller = new JScrollPane(answer);
       aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

       JButton nextButton = new JButton("Next Card");

       cardList = new ArrayList<QuizCard>();

       JLabel qLabel = new JLabel("Question:");
       JLabel aLabel = new JLabel("Answer:");

       mainPanel.add(qLabel);
       mainPanel.add(qScroller);
       mainPanel.add(aLabel);
       mainPanel.add(aScroller);
       mainPanel.add(nextButton);
       nextButton.addActionListener(new NextCardListener());
       JMenuBar menuBar = new JMenuBar();
       JMenu fileMenu = new JMenu("File");
       JMenuItem newMenuItem = new JMenuItem("New");
       JMenuItem saveMenuItem = new JMenuItem("Save");
       newMenuItem.addActionListener(new NewMenuListener());

       saveMenuItem.addActionListener(new SaveMenuListener());
       fileMenu.add(newMenuItem);
       fileMenu.add(saveMenuItem);
       menuBar.add(fileMenu);
       frame.setJMenuBar(menuBar);
       frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
       frame.setSize(500,600);
       frame.setVisible(true);

    }

    private class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
         //add the current card to the list and clear the 
         //text areas 
         QuizCard card = new QuizCard(question.getText(), answer.getText());
         cardList.add(card);
         clearCard();  
        }
    }

    private class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //bring up a file dialog box
            //let the use name and save the set
        }
    }

    private class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //clear out the card list, and clear out the text
            //aread
        }
    }

    private void saveFile(File file) {
        //iterate through the list of cards, and werite each out
        //to a text file 
        //in a parseable way
    }

}