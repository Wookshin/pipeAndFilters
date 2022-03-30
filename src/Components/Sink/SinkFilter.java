package Components.Sink;
/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */

import java.io.FileWriter;
import java.io.IOException;

import Framework.GeneralFilter;

/**
 * @author Jungho Kim
 * @date 2019
 * @version 1.1
 * @description
 */
public class SinkFilter extends GeneralFilter{
    private String sinkFile;
    
    public SinkFilter(String outputFile) {
        this.sinkFile = outputFile;
    }

    @Override
    public void specificComputationForFilter() throws IOException {
        int byte_read;
        
        FileWriter fw = new FileWriter(this.sinkFile);
        while(true) {
            byte_read = in.read(); 
            if (byte_read == -1) {
            	 fw.close();
                 System.out.print( "::Filtering is finished; Output file is created." );  
                 return;
            }
            fw.write((char)byte_read);
        }   
    }
}
