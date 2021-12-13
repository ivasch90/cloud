package com.geekbrains;

import com.geekbrains.AbstractMessage;

import java.util.List;

public class ServerListOfFiles extends AbstractMessage {
    private final List<String> serverFileList;

    public ServerListOfFiles(List<String> serverFileList) {
        this.serverFileList = serverFileList;
    }

    public List<String> getServerFileList() {
        return serverFileList;
    }
}
