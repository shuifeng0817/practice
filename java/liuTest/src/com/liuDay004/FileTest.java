package com.liuDay004;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

class FileTest extends ClassLoader {
    private static final String CLASS_FILE_PATH = "D:" + File.separator + "InsertSort.class";

    public Class<?> loadData(String className) throws Exception {
        byte data[] = this.loadFileClassData();
        if (data != null) {
            return super.defineClass(className, data, 0, data.length);
        }
        return null;
    }


    private byte[] loadFileClassData() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(CLASS_FILE_PATH));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        fileInputStream.transferTo(byteArrayOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();
        fileInputStream.close();
        byteArrayOutputStream.close();
        return data;
    }
}
