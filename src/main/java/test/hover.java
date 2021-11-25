package test;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class hover extends JTextArea {
    // make sure Eclipse doesn't show a warning
    private static final long serialVersionUID = 1L;

    // switch to display debugging tooltip
    boolean debug=false;

    /**
     * the map of tool tips per line
     */
    public Map<Integer,String> lineToolTips=new HashMap<Integer,String>();

    /**
     * create me with the given rows and columns
     * @param rows
     * @param cols
     */
    public hover(int rows, int cols) {
        super(rows,cols);
        // initialize the tool tip event handling
        this.setToolTipText("");
    }

    /**
     * add a tool tip for the given line
     * @param line - the line number
     * @param tooltip -
     */
    public void addToolTip(int line, String tooltip) {
        lineToolTips.put(line,tooltip);
    }

    /**
     * get the ToolTipText for the given mouse event
     * @param event - the mouse event to handle
     */
    public String getToolTipText(MouseEvent event) {
        // convert the mouse position to a model position
        int viewToModel =viewToModel(event.getPoint());
        // use -1 if we do not find a line number later
        int lineNo=-1;
        // debug information
        String line=" line ?";
        // did we get a valid view to model position?
        if(viewToModel != -1){
            try {
                // convert the modelPosition to a line number
                lineNo = this.getLineOfOffset(viewToModel)+1;
                // set the debug info
                line=" line "+lineNo;
            } catch (BadLocationException ble) {
                // in case the line number is invalid ignore this
                // in debug mode show the issue
                line=ble.getMessage();
            }
        }
        // try to lookup the tool tip - will be null if the line number is invalid
        // if you want to show a general tool tip for invalid lines you might want to
        // add it with addToolTip(-1,"general tool tip")
        String toolTip=this.lineToolTips.get(lineNo);
        // if in debug mode show some info
        if (debug)  {
            // different display whether we found a tooltip or not
            if (toolTip==null) {
                toolTip="no tooltip for line "+lineNo;
            } else {
                toolTip="tooltip: "+toolTip+" for line "+lineNo;
            }
            // generally we add the position info for debugging
            toolTip+=String.format(" at %3d / %3d ",event.getX(),event.getY());
        }
        // now return the tool tip as wanted
        return toolTip;
    }
}
