package cn.javass.common.datasource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ClassLoaderTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {  
        //新建一个类加载器  
        MyClassLoader cl = new MyClassLoader("myClassLoader");  
        //加载类，得到Class对象  
        Class<?> clazz = cl.loadClass("cn.javass.common.datasource.Animal");  
        //得到类的实例  
        Animal animal=(Animal) clazz.newInstance();  
        animal.say();  
    }  
}

class MyClassLoader extends ClassLoader {  
	String src = "D:\\workspace\\learn\\spring-master\\src\\main\\java\\cn\\javass\\common\\datasource";
	String classs = "D:\\workspace\\learn\\spring-master\\target\\classes\\cn\\javass\\common\\datasource\\";
    //类加载器的名称  
    private String name;  
    //类存放的路径  D:\workspace\learn\spring-master\target\classes\cn\javass\common\datasource
    //D:\\workspace\\learn\\spring-master\\src\\main\\java\\cn\\javass\\common\\datasource
  
      String path = classs;  
    MyClassLoader(String name) {  
        this.name = name;  
    }  
    MyClassLoader(ClassLoader parent, String name) {  
        super(parent);  
        this.name = name;  
    }  
    /** 
     * 重写findClass方法 
     */  
    @Override  
    public Class<?> findClass(String name) {  
    	System.out.println("11111111");
        byte[] data = loadClassData( name);  
        return this.defineClass( name, data, 0, data.length);  
    }  
    public byte[] loadClassData(String name) {  
        try {  
            name = name.replace(".", "//");  
            FileInputStream is = new FileInputStream(new File(path + name + ".class"));  
            ByteArrayOutputStream baos = new ByteArrayOutputStream();  
            int b = 0;  
            while ((b = is.read()) != -1) {  
                baos.write(b);  
            }  
            return baos.toByteArray();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
}