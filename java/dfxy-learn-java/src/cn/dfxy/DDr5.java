package cn.dfxy;

/**
 * ddr5规范接口
 */
interface DDr5{
    /**
     * 内存读取
     */
    void write();

    /**
     * 内存写入
     */
    void read();
}

