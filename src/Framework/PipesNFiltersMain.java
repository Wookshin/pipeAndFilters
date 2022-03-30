package Framework;
import java.util.ArrayList;
import java.util.Arrays;

import Components.Middle.AddFilter;
import Components.Middle.PassFailFilter;
import Components.Middle.SubjectFilter;
import Components.Sink.SinkFilter;
import Components.Source.SourceFilter;

/**
 * Copyright(c) 2019 All rights reserved by JU Consulting
 */


/**
 * @author Jungho Kim
 * @date 2019
 * @version 1.1
 * @description
 *     
 */
public class PipesNFiltersMain {

    public static void main(String[] args) {
        try {
            //문제1-2. 모든 EE 학생 들은 23456 과목을 수강해야 한다.  이 들  과목 을 수강 신청하지 않은 학생들을 골라 이 들 과목 ID를 추가하시오. 
//            CommonForFilter sourceFilter = new SourceFilter("Students.txt");
//            CommonForFilter sinkFilter = new SinkFilter("Output.txt");
//            CommonForFilter subjectFilter = new SubjectFilter("EE");
//            CommonForFilter addFilter = new AddFilter(new ArrayList<String>( Arrays.asList("23456")));
//
//            sourceFilter.connectOutputTo(subjectFilter);
//            subjectFilter.connectOutputTo(addFilter);
//            addFilter.connectOutputTo(sinkFilter);
//            
//            Thread sourceThread = new Thread(sourceFilter);
//            Thread sinkThread = new Thread(sinkFilter);
//            Thread subjectThread = new Thread(subjectFilter);
//            Thread addThread = new Thread(addFilter);
//            
//            sourceThread.start();
//            sinkThread.start();
//            subjectThread.start();
//            addThread.start();
            
            //문제2. 학생 정보(Students.txt)와 동시에 선수 과목 정보가 들어있는 과목 정보(Courses.txt)를 시스템에 입력하시오.
    		//과목 정보를 기준으로 선수 과목 기준에 만족하는 학생들과 만족하지 않는 학생 정보를 분리하여 별도의 화일로 출력하시오. (예 : Output-1.txt, Output-2.txt)

            CommonForFilter sourceFilter = new SourceFilter("Students.txt");
            CommonForFilter sourceFilter2 = new SourceFilter("Courses.txt");
            CommonForFilter sinkFilter = new SinkFilter("Output-1.txt");
            CommonForFilter sinkFilter2 = new SinkFilter("Output-2.txt");
            CommonForFilter passFailFilter = new PassFailFilter();

            sourceFilter.connectOutputTo(passFailFilter);
            sourceFilter2.connectOutputTo(passFailFilter);
            passFailFilter.connectOutputTo(sinkFilter);
            passFailFilter.connectOutputTo(sinkFilter2);
            
            Thread sourceThread = new Thread(sourceFilter);
            Thread sourceThread2 = new Thread(sourceFilter2);
            Thread sinkThread = new Thread(sinkFilter);
            Thread sinkThread2 = new Thread(sinkFilter2);
            Thread passFailThread = new Thread(passFailFilter);
            
            sourceThread.start();
            sourceThread2.start();
            sinkThread.start();
            sinkThread2.start();
            passFailThread.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}


