package com.gouzhong1223.gzchat;

import com.gouzhong1223.gzchat.server.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class GzchatApplication implements CommandLineRunner {

    @Value("${netty.port}")
    private Integer port;

    @Value("${netty.url}")
    private String url;

    private final NettyServer nettyServer;

    private static final Logger LOGGER = LoggerFactory.getLogger(GzchatApplication.class);

    public GzchatApplication(NettyServer nettyServer) {
        this.nettyServer = nettyServer;
    }

    public static void main(String[] args) {
        SpringApplication.run(GzchatApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(url, port);
        LOGGER.info("Netty 服务端启动。。。");
        nettyServer.start(inetSocketAddress);
    }
}
