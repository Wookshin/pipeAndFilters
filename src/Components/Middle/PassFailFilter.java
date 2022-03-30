package Components.Middle;
/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

import Framework.GeneralFilter;


/**
 * @author Jungho Kim
 * @date 2019
 * @version 1.1
 * @description
 */
public class PassFailFilter extends GeneralFilter{
	public PassFailFilter() {
	}

    @Override
    public void specificComputationForFilter() throws IOException {
    	// 특정 과목이 없을 경우 특정 과목 추가
    	int checkBlank = 4; 
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[64];
        ArrayList<String> existSubjects = new ArrayList<String>();
        int byte_read = 0;
 
        while(true) {
        	existSubjects.clear();
            while(byte_read != '\n' && byte_read != -1) {
            	byte_read = in.read();
                if(byte_read == ' '){
                    numOfBlank++;
                }   
                if(byte_read != -1){
                    buffer[idx++] = (byte)byte_read;
                }
                if(numOfBlank > checkBlank && byte_read == ' '){
                	byte[] tmpBuffer = new byte[5];
                	for (int i=0; i<5; i++) {
                		tmpBuffer[i] = buffer[idx-6+i];
                	}
                    String subject = new String(tmpBuffer);
                    //System.out.println(subject);
                    existSubjects.add(subject);
                }
            }
            
            for (String shouldAddSubject : shouldAddSubjects) {
            	boolean isExist = false;
//            	System.out.println("--------------------");
            	for (String existSubject : existSubjects) {
//            		System.out.println(shouldAddSubject + " " + existSubject);
					if (existSubject.equals(shouldAddSubject)) {
						isExist = true;
						break;
					}
				}
            	
            	if (!isExist) {
            		byte[] bytes = shouldAddSubject.getBytes();
            		buffer[idx-2] = ' ';
            		idx--;
            		for(int i=0; i<bytes.length; i++) {
            			buffer[idx++] = bytes[i];
            		}
            		buffer[idx++] = '\n';
            	}
			}
            
            for(int i = 0; i<idx; i++) {
                out.write((char)buffer[i]);
            	//System.out.print((char)buffer[i]);
            }
            
            if (byte_read == -1) return;
            
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }  
}
