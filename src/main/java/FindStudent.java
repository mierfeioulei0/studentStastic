import cn.von.vo.Student;

import java.util.ArrayList;

/**
 * Created by mierfeioulei0 on 2018/10/6.
 */
public class FindStudent {
    public Student fromName(ArrayList<Student> students, String name){
        Student student=new Student();
        for(int i=0;i<students.size();i++)
        {
            if(name.equals(students.get(i).getName()))
            {
                student=students.get(i);
            }
        }
        return  student;
    }
}
