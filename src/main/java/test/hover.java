// java Program to submit name using JTextField and the tooltip
// text shows the previous entries.(using
// getToolTipText function)
package test ;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class hover extends JFrame implements ActionListener {

    // frame
    static JFrame f;

    // text areas
    static JTextField t1;

    // buttons
    static JButton b;

    // main class
    public static void main(String[] args)
    {
        // create a new frame
        f = new JFrame("frame");

        // create a object
        hover s = new hover();

        // create a panel
        JPanel p = new JPanel();

        // create a text area
        t1 = new JTextField(20);

        // create a button
        b = new JButton("submit");

        // add actionlistener
        b.addActionListener(s);

        // create a multi line string using html using break tags
        String s1 = "<html> key W and D to move around <br> SPACEBAR to start ball  <br>  <br> ESC to go to Pause Menu<br>      </html>";

        // set tooltip text
        t1.setToolTipText(s1);

        // add text area and button
        p.add(t1);
        p.add(b);

        // add panel
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);

        f.show();
    }

    // if a button is performed
    public void actionPerformed(ActionEvent e)
    {
        // if submit button is pressed add the name to the list of entries
        // exclude the closing html tag by taking its substring
        // add the name to the list of entries
        // and add the html tag to the end of it

        // get the tooltip text
        String s = t1.getToolTipText();

        t1.setToolTipText(s.substring(0, s.length() - 8) + t1.getText() + "<br>      <html");
    }
}