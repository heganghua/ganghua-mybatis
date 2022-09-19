package xyz.ganghua.shange;

import java.io.File;

import xyz.ganghua.shange.service.ReadWordFile;

public class ShangeApplication {
    public static void main(String[] args) {

        File file = null;
        int length = args.length;
        if (length > 0) {
            String arg = args[0];
            System.out.println(arg);
            file = new File(arg);
            if (!file.exists()) {
                throw new RuntimeException("山哥，路径可能有错误哦！请再核对一下路径");
            } else {
                System.out.println("接受到山哥传过来的参数，     参数为： " + arg);
            }

        } else {
            file = new File("../file");
        }
        // 处理文档
        ReadWordFile.run(file);
    }
}
