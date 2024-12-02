package fr.itii25.commands;

import fr.itii25.dao.DAO;

public class DataCommand extends Command {

    private Object data;

    public DataCommand(Object data) {
        this.data = data;
    }

    @Override
    public void execute() {
    }
}
