package com.sunyue.study.cl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class HotClassLoader extends ClassLoader {  
	  
    public HotClassLoader(){  
        super(null);  
    }  
      
    @Override  
    protected Class<?> findClass(String name) throws ClassNotFoundException {  
        byte[] data = loadClassData(name);  
        return this.defineClass(name, data, 0, data.length);  
    }  
      
    public byte[] loadClassData(String name) {  
        try {  
            name = name.replace(".", "//");  
            FileInputStream is = new FileInputStream(new File(  
            		"C:\\Users\\essnyye\\work\\codes\\study\\bin\\" + name + ".class"));  
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
  
    @Override  
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {  
        Class cls = null;  
        cls = findLoadedClass(name);  
        if(!name.equals("com.sunyue.study.cl.ObjectWithStatic") && cls == null){  
            cls = getSystemClassLoader().loadClass(name);  
        }else{  
            try{  
                cls = findClass(name);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
        }  
        if (cls == null)  
            throw new ClassNotFoundException(name);  
        if (resolve)  
            resolveClass(cls);  
        return cls;  
    }  
      
}  