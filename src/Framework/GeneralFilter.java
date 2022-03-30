package Framework;
/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */

import java.io.EOFException;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;


/**
 * @author Jungho Kim
 * @date 2019
 * @version 1.1
 * @description
 */
public abstract class GeneralFilter implements CommonForFilter{
    protected ArrayList<PipedInputStream> inArray = new ArrayList<PipedInputStream>();
    protected ArrayList<PipedOutputStream> outArray = new ArrayList<PipedOutputStream>();
    
/**********Implementation of public methods defined in CommonForFilter interface************/
    
    public void connectOutputTo(CommonForFilter nextFilter) throws IOException {
    	PipedInputStream in = new PipedInputStream();
    	PipedOutputStream out = new PipedOutputStream();
    	inArray.add(in);
    	outArray.add(out);
    	out.connect(nextFilter.getPipedInputStream());
    }
    
    public void connectInputTo(CommonForFilter previousFilter) throws IOException {
    }
    
    public PipedInputStream getPipedInputStream() { 
        return inArray.get(inArray.size()-1);
    }
    
    public PipedOutputStream getPipedOutputStream() { 
        return outArray.get(outArray.size()-1);
    }

/**********Implementation of public methods defined in Runnable interface************/    

    public void run() {
        try { 
            specificComputationForFilter(); 
        } catch (IOException e) {
            if (e instanceof EOFException) return;
            else System.out.println(e);
        } finally {
            try { 
                out.close(); 
                in.close(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            }
        }
    }

/**********Implementation of protected methods************/    
    
    protected void closePorts() {
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }
    
/**********Abstract method that should be implemented************/    
    
    abstract public void specificComputationForFilter() throws IOException;
}
