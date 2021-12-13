package com.geekbrains.client;

import com.geekbrains.AbstractMessage;
import com.geekbrains.Commands;
import com.geekbrains.ServerListOfFiles;
import com.geekbrains.StringMessage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ClientAppController implements Initializable {

    public ListView<String> listViewServerPath;
    public TextField textFieldPath;
    public Button btnUpdate;
    private Path serverPath;
    private OnMessageReceived callback;
    private NettyNet net;
    public Button btnExit;
    private List<String> filesOnListView;
    private AbstractMessage abstractMessage;


    @FXML
    public void btnActionExit(javafx.event.ActionEvent actionEvent) {
        Platform.exit();
    }

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        net = new NettyNet(this.callback);

        //net.sendMessage(new StringMessage("dsadasdas"));

        //serverPath = Paths.get("server");
        //fillServerListView();
        //fillTextFieldPath();

    }

    private void fillServerListView () throws IOException {
        List<String> files = Files.list(serverPath)
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());
        listViewServerPath.getItems().addAll(files);
    }

    private void fillTextFieldPath () {
        textFieldPath.setText(serverPath.toString());
    }

    public void btnUpdateListFiles(ActionEvent actionEvent) {
        new StringMessage("ls");
        receivedAndFillListView();

    }
    public void receivedAndFillListView () {
        try {
            Method getList = ClientMessageHandler.class.getMethod("getList");
            getList.invoke(null);
            listViewServerPath.getItems().addAll();
        } catch (Exception e) {
            log.error("e=", e);
        }
    }
}
