package com.cooperstandard.race.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;

import javax.swing.*;
import java.awt.*;

public class ImageUtil {

    public static ImageIcon getImageIcon(String path) {
        try {
            return new ImageIcon(new ClassPathResource(path).getURL());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Image getImage(String path) {
        return getImageIcon(path).getImage();
    }

    public static ImageIcon getImageIconFromUserPath(String path) {
        try {
            return new ImageIcon(new PathResource(path).getURL());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Image getImageFromUserPath(String path) {
        return getImageIconFromUserPath(path).getImage();
    }

}
