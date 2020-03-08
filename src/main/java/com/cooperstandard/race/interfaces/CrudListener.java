package com.cooperstandard.race.interfaces;

public interface CrudListener {

    default String actionPerformance(String actionCommand) {
        switch (actionCommand.toLowerCase()) {
            case "save":
            case "update":
                saveOrUpdate();
                break;
            case "delete":
                delete();
                break;
            case "search":
                search();
                break;
        }
        return actionCommand;
    }

    void saveOrUpdate();

    void delete();

    void search();

}
