package com.geekbrains.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.debug("Client disconnected...");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.debug("Client connected...");
    }


    @Override
    protected void channelRead0(ChannelHandlerContext cht, String s) throws Exception {
        log.debug("Received: {}", s);
        cht.writeAndFlush("Hello " + s);


    }
}
