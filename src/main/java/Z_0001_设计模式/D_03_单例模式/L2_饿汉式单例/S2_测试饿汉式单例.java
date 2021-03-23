package Z_0001_设计模式.D_03_单例模式.L2_饿汉式单例;


import Z_utils.输出;

public class S2_测试饿汉式单例 {

    private static void 正常测试() {
        输出.当前方法全名("开始。");
        S1_饿汉式单例 s1 = S1_饿汉式单例.getInstance();
        S1_饿汉式单例 s2 = S1_饿汉式单例.getInstance();
        // S1_饿汉式单例 s3 = new S1_饿汉式单例(); new 编译报错 private 不允许创建
        System.out.println((s1 == s2) ? "正常测试通过!" : "正常测试失败！");
    }

    public static void main(String[] args) {
        正常测试(); // 天生线程安全，不需要测试多线程，缺点，牺牲空间换线程安全
    }

}
