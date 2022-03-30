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
public class DBSinkFilter extends GeneralFilter{
    private String sinkFile;
    
    public DBSinkFilter(String outputFile) {
        this.sinkFile = outputFile;
    }

    @Override
    public void specificComputationForFilter() throws IOException {
        // DB ¿˙¿Â
    }
}
