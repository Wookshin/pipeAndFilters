package Components.Middle;
/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */

import java.io.EOFException;
import java.io.IOException;

import Framework.GeneralFilter;


/**
 * @author Jungho Kim
 * @date 2019
 * @version 1.1
 * @description
 */
public class SubjectFilter extends GeneralFilter{
	private String subject;
	
	public SubjectFilter (String subject) {
		this.subject = subject;
	}
	
    @Override
    public void specificComputationForFilter() throws IOException {
    	int checkBlank = 4; 
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[64];
        boolean isCS = false;
        
        int byte_read = 0;
 
        while(true) {
            
        	// check Subject on byte_read from student information
            while(byte_read != '\n' && byte_read != -1) {
            	byte_read = in.read();
                if(byte_read == ' '){
                    numOfBlank++;
                }   
                if(byte_read != -1){
                    buffer[idx++] = (byte)byte_read;
                }
                if(numOfBlank == checkBlank && buffer[idx-3] == subject.charAt(0) && buffer[idx-2] == subject.charAt(1)){
                    isCS = true;
                }
            }
            
            if(isCS == true) {
                for(int i = 0; i<idx; i++) {
                    out.write((char)buffer[i]);
                	//System.out.print((char)buffer[i]);
                }
                isCS = false;
            }
            
            if (byte_read == -1) return;
            
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }  
}
