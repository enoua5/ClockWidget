/*
 * The menu that comes up when the user right clicks.
 * Initializer adds in all the options, with the text and some code to run.
 * 
 * TODO:
 * Add menu option to bring up settings window
 * 
 * --Jacob Allen
 */
import javax.swing.*;
import java.awt.event.*;
public class RightClickMenu extends JPopupMenu
{
    public RightClickMenu()
    {
        this.add(new JMenuItem(new AbstractAction("Close"){
            public void actionPerformed(ActionEvent e)
            {
                //code to run when close is clicked
                Settings.save();
                Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
            }
        }));
    }
}
