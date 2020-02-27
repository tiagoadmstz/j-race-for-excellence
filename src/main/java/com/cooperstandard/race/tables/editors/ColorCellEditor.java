package com.cooperstandard.race.tables.editors;

import javax.swing.*;
import java.awt.*;

public class ColorCellEditor extends DefaultCellEditor {

    public ColorCellEditor() {
        super(new JComboBox(new Color[]{new Color(255, 0, 0), new Color(255, 255, 0), new Color(0, 255, 0)}));
    }

}
