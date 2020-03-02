/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.interfaces;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Tiago
 * @param <T>
 */
public abstract class DefaultListenerCustom<T extends JFrame> implements ActionListener {

    protected final T frame;

    public DefaultListenerCustom(T frame) {
        this.frame = frame;
        initComponents();
    }

    protected void initComponents(){
        attachListeners();
        initTable();
    }
    
    protected abstract void attachListeners();

    protected abstract void initTable();

}
