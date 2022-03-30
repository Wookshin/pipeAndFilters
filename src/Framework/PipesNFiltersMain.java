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
            //����1-2. ��� EE �л� ���� 23456 ������ �����ؾ� �Ѵ�.  �� ��  ���� �� ���� ��û���� ���� �л����� ��� �� �� ���� ID�� �߰��Ͻÿ�. 
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
            
            //����2. �л� ����(Students.txt)�� ���ÿ� ���� ���� ������ ����ִ� ���� ����(Courses.txt)�� �ý��ۿ� �Է��Ͻÿ�.
    		//���� ������ �������� ���� ���� ���ؿ� �����ϴ� �л���� �������� �ʴ� �л� ������ �и��Ͽ� ������ ȭ�Ϸ� ����Ͻÿ�. (�� : Output-1.txt, Output-2.txt)

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


