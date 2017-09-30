import javax.swing.*;
import java.awt.event.*;
public class RightClickMenu extends JPopupMenu
{
    public RightClickMenu()
    {
        this.add(new JMenuItem(new AbstractAction("Close")
        {
            public void actionPerformed(ActionEvent e)
            {
                Main.f.dispatchEvent(new WindowEvent(Main.f, WindowEvent.WINDOW_CLOSING));
            }
        }));
    }
}
