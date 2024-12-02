package fr.itii25.commands;

public abstract class Command {

    protected Runnable thread;

    public abstract void execute();
}
