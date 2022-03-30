package Components.Source;
/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import Framework.GeneralFilter;


/**
 * @author Jungho Kim
 * @date 2019
 * @version 1.1
 * @description
 */
public class SourceFilter extends GeneralFilter{
    private String sourceFile;
    
    public SourceFilter(String inputFile){
        this.sourceFile = inputFile;
    }    

    @Override
    public void specificComputationForFilter() throws IOException {
        int byte_read;
        
        @SuppressWarnings("resource")
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File(sourceFile)));
        
        while(true) {
            byte_read = br.read();
            if (byte_read == -1) return;
            out.write(byte_read);
        }
    }
}
