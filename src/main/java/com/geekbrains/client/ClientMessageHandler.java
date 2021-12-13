package com.geekbrains.client;

import com.geekbrains.AbstractMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.event.ActionEvent;

import java.lang.reflect.Method;
import java.util.List;

public class ClientMessageHandler extends SimpleChannelInboundHandler<AbstractMessage> {

    private final OnMessageReceived callback;
    private List<String> list;

    public ClientMessageHandler(OnMessageReceived callback) {
        this.callback = callback;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AbstractMessage abstractMessage) throws Exception {
        callback.onReceive(abstractMessage);
        list = (List<String>) abstractMessage;
    }

    public List<String> getList() {
        return list;
    }
}
