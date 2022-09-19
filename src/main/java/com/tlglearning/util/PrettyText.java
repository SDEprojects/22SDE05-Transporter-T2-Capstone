package main.java.com.tlglearning.util;

enum PrettyText {
CYAN ("\u001B[36m"), RED("\u001B[31m"), RESET("\u001B[0m"), WHITE("\u001B[37m"), GREEN("\u001B[32m");

    private String color;

    PrettyText(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
