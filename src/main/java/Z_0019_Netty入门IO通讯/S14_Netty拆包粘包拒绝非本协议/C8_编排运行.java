package Z_0019_Netty入门IO通讯.S14_Netty拆包粘包拒绝非本协议;

public class C8_编排运行 {

    /**
     * 端口[8000]绑定成功!
     * 开始登录...
     * 协议匹配不上：传入 68 解码 -2023406815
     * 协议匹配不上：传入 68 解码 -2023406815
     * 协议匹配不上：传入 68 解码 -2023406815
     */
    public static void main(String[] args) {
        C6_服务端.运行();
        C7_客户端.运行();
    }
}
