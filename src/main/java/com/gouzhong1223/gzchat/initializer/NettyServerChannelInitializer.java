package com.gouzhong1223.gzchat.initializer;

import com.gouzhong1223.gzchat.handler.NettyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : Netty初始化
 * @Date : create by QingSong in 2020-07-10 12:34 上午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : org.gouzhong1223.springbootnettydemo02.initializer
 * @ProjectName : netty-learn
 * @Version : 1.0.0
 */
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        // 设置解码器
        channel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        // 设置编码器
        channel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        // 添加自定义处理器
        channel.pipeline().addLast(new NettyServerHandler());
    }
}
