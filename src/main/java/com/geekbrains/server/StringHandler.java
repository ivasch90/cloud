package com.geekbrains.server;

import com.geekbrains.AbstractMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringHandler extends SimpleChannelInboundHandler<AbstractMessage> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.debug("Client disconnected...");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.debug("Client connected...");
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AbstractMessage message) throws Exception {
        log.debug("Received: {}", message);
        channelHandlerContext.writeAndFlush("Hello " + message);
    }
}
