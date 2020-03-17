/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.race.tables.interfaces;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @param <T>
 * @author Tiago
 */
public abstract class DefaultTableModelCustom<T> extends AbstractTableModel {

    protected List<T> list = new ArrayList();
    protected String[] columnsNames = getColumnsNames();

    public DefaultTableModelCustom() {
    }

    public DefaultTableModelCustom(List<T> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnsNames.length;
    }

    protected abstract String[] getColumnsNames();

    @Override
    public String getColumnName(int column) {
        return columnsNames[column];
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public void addObject(T object) {
        list.add(object);
        fireTableDataChanged();
    }

    public void removeObject(T object) {
        list.remove(list.indexOf(object));
        fireTableDataChanged();
    }

    public void removeObject(int index) {
        if (list.size() - 1 >= index) {
            list.remove(index);
            fireTableDataChanged();
        }
    }

    public void removeObjects(int... indexes) {
        list.removeAll(Arrays.stream(indexes).boxed().map(id -> list.get(id)).collect(Collectors.toList()));
        fireTableDataChanged();
    }

    public T getObject(int rowIndex) {
        if (rowIndex >= 0) return list.get(rowIndex);
        return null;
    }

}
