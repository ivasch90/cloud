package com.geekbrains.server;

import com.geekbrains.AbstractMessage;
import com.geekbrains.ServerListOfFiles;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MessageHandler extends SimpleChannelInboundHandler<AbstractMessage> {
    public Path serverPath = Paths.get("server");

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AbstractMessage abstractMessage) throws Exception {

        log.debug(serverPath.toString());
        File[] files = serverPath.toFile().listFiles();
        List<String> stringList = Arrays.stream(files).map(p -> p.getName())
                .collect(Collectors.toList());

        //log.debug("Received: {}", abstractMessage);
        //ctx.writeAndFlush(abstractMessage);
        ctx.writeAndFlush(new ServerListOfFiles(stringList));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        log.debug("Client connected...");


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.debug("Client disconnected");
    }
}
