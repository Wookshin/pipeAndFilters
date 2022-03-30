package Framework;
/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


/**
 * @author Jungho Kim
 * @date 2019
 * @version 1.1
 * @description
 *      모든 Filter 들이 공유하는 Interface. Runnable을 extend 해서 모든 Filter들은 기본적으로 Thread 기반으로 돌아감을 보이고, Filter간의 소통을 위한 기본적인 connect 메소드들을 정의함.
 */
public interface CommonForFilter extends Runnable{
    /**
     * @param filter
     * @throws IOException
     */
    public void connectOutputTo(CommonForFilter filter) throws IOException;
    
    
    /**
     * @param filter
     * @throws IOException
     */
    public void connectInputTo(CommonForFilter filter) throws IOException;
    
    
    /**
     * @return PipedInputStream
     */
    public PipedInputStream getPipedInputStream();
    
    
    /**
     * @return PipedOutputStream
     */
    public PipedOutputStream getPipedOutputStream();
}
