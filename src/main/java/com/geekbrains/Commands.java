package com.geekbrains;

public enum Commands {
    LIST_OF_FILES("ls"),
    CREATE_FILE("touch"),
    CREATE_DIR("mkdir"),
    DELETE("rm"),
    RENAME("rename"),
    MOVE("move");


    String name;

    Commands(String name) {
        this.name = name;
    }

}
