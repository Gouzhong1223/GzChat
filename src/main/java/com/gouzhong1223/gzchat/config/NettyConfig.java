package com.gouzhong1223.gzchat.config;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : Netty 配置
 * @Date : create by QingSong in 2020-07-09 5:47 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : org.gouzhong1223.springbootnettywebsocketdemo.handler
 * @ProjectName : netty-learn
 * @Version : 1.0.0
 */
public class NettyConfig {

    /**
     * 定义一个channel组，管理所有的channel
     * GlobalEventExecutor.INSTANCE 是全局的事件执行器，是一个单例
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 存放用户与Chanel的对应信息，用于给指定用户发送消息
     */
    private static ConcurrentHashMap<String, Channel> userChannelMap = new ConcurrentHashMap<>();

    private NettyConfig() {
    }

    /**
     * 获取channel组
     *
     * @return
     */
    public static ChannelGroup getChannelGroup() {
        return channelGroup;
    }

    /**
     * 获取用户channel map
     *
     * @return
     */
    public static ConcurrentHashMap<String, Channel> getUserChannelMap() {
        return userChannelMap;
    }

}
