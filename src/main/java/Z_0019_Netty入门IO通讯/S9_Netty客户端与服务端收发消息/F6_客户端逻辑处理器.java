package Z_0019_Netty入门IO通讯.S9_Netty客户端与服务端收发消息;

import Z_0019_Netty入门IO通讯.S9_Netty客户端与服务端收发消息.F0_协议.F1_抽象数据包;
import Z_0019_Netty入门IO通讯.S9_Netty客户端与服务端收发消息.F0_协议.F5_编码;
import Z_0019_Netty入门IO通讯.S9_Netty客户端与服务端收发消息.F0_协议.F5_解码;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

/**
 * 描述：
 * @author zengyufei
 */
public class F6_客户端逻辑处理器 extends ChannelInboundHandlerAdapter {

    /**
     * 连接上后直接请求登录
     */
    @Override
    public void channelActive(ChannelHandlerContext 上下文) throws Exception {
        System.out.println("连接上了，马上登录！");
        F4_登录请求数据包 登录请求数据包 = new F4_登录请求数据包();
        登录请求数据包.姓名 = "管理员";
        登录请求数据包.账号 = "admin";
        登录请求数据包.密码 = "admin1";
        ByteBuf 编码后的请求数据包 = F5_编码.编码(上下文.alloc(), 登录请求数据包);
        上下文.writeAndFlush(编码后的请求数据包);
    }

    @Override
    public void channelRead(ChannelHandlerContext 上下文, Object 消息) throws Exception {
        ByteBuf 数据载体 = (ByteBuf) 消息;
        F1_抽象数据包 解码后的数据包 = F5_解码.解码(数据载体);
        if (解码后的数据包 instanceof F4_登录响应数据包) {
            String 代码 = ((F4_登录响应数据包) 解码后的数据包).代码;
            String 是否成功 = ((F4_登录响应数据包) 解码后的数据包).是否成功;
            if ("true".equals(代码)&&"成功".equals(是否成功)) {
                System.out.println("登录是否成功：[" + 是否成功 + "]");
                给服务器发送自定义消息(上下文);
            }else{
                // 因为密码错误，所以重新登录
                System.out.println("因为密码错误，所以重新登录");
                F4_登录请求数据包 登录请求数据包 = new F4_登录请求数据包();
                登录请求数据包.姓名 = "管理员";
                登录请求数据包.账号 = "admin";
                登录请求数据包.密码 = "admin";
                ByteBuf 编码后的请求数据包 = F5_编码.编码(上下文.alloc(), 登录请求数据包);
                上下文.writeAndFlush(编码后的请求数据包);
            }
        } else if (解码后的数据包 instanceof F4_发送消息响应数据包) {
            System.out.println("收到服务端发来消息：[" + ((F4_发送消息响应数据包) 解码后的数据包).消息 + "]");
            // 给服务器发送消息
            给服务器发送自定义消息(上下文);
        }
    }
    
    private void 给服务器发送自定义消息(ChannelHandlerContext 上下文) {
        // 登录成功后给服务器发送消息
        F4_发送消息请求数据包 发送消息请求数据包 = new F4_发送消息请求数据包();
        System.out.println("请输入：");
        Scanner 控制台输入器 = new Scanner(System.in);
        String 控制台输入一行 = 控制台输入器.nextLine();
        发送消息请求数据包.消息 = 控制台输入一行;
        //发送消息请求数据包.消息 = "你好，服务器.";
        ByteBuf 编码后的消息请求载体 = F5_编码.编码(上下文.alloc(), 发送消息请求数据包);
        上下文.writeAndFlush(编码后的消息请求载体);
    }
    
}
