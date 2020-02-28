package com.cooperstandard.race.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class IconThumbSliderUI extends BasicSliderUI {

    protected Icon hThumbIcon = null;
    protected Icon vThumbIcon = null;

    public IconThumbSliderUI(JSlider b, Icon hThumbIcon, Icon vThumbIcon) {
        super(b);
        setHorizontalThumbIcon(hThumbIcon);
        setVerticalThumbIcon(vThumbIcon);
    }

    public void setHorizontalThumbIcon(Icon hThumbIcon) {
        if (hThumbIcon == null) {
            //this.hThumbIcon = horizThumbIcon;
        } else {
            this.hThumbIcon = hThumbIcon;
        }
    }

    public void setVerticalThumbIcon(Icon vThumbIcon) {
        if (vThumbIcon == null) {
            //this.vThumbIcon = vertThumbIcon;
        } else {
            this.vThumbIcon = vThumbIcon;
        }

    }

    public void paintThumb(Graphics g) {
        Rectangle knobBounds = thumbRect;

        g.translate(knobBounds.x, knobBounds.y);

        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            hThumbIcon.paintIcon(slider, g, 0, 0);
        } else {
            vThumbIcon.paintIcon(slider, g, 0, 0);
        }

        g.translate(-knobBounds.x, -knobBounds.y);
    }

    protected Dimension getThumbSize() {
        Dimension size = new Dimension();

        if (slider.getOrientation() == JSlider.VERTICAL) {
            size.width = vThumbIcon.getIconWidth();
            size.height = vThumbIcon.getIconHeight();
        } else {
            size.width = hThumbIcon.getIconWidth();
            size.height = hThumbIcon.getIconHeight();
        }

        return size;
    }
}
