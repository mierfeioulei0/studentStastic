import cn.von.vo.Score;
import cn.von.vo.Student;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理Excel文件
 *
 * @author mierfeioulei0
 * @version 1.0
 * @since 2018/10/5
 */
public class ExcelProcessor {

    /**
     * 读取Excel文件
     *
     * @param excelFile
     * @return 学生列表
     * @throws Exception
     */
    public ArrayList<Student> excelToArray(File excelFile) throws Exception {
        //1:创建workbook
        int flag = 0;
        Workbook workbook = Workbook.getWorkbook(excelFile);
        //2:获取第一个工作表sheet
        Sheet sheet = workbook.getSheet(0);
        //3:获取数据
     //   System.out.println("行：" + sheet.getRows());
     //   System.out.println("列：" + sheet.getColumns());
        ArrayList<Student> studentList = new ArrayList<>();

        for (int i = 1; i < sheet.getRows(); i++) {
            Student student = new Student();
            ArrayList<Score> scoreList = new ArrayList<>();

            for (int j = 0; j < sheet.getColumns(); j++) {
                Cell cell = sheet.getCell(j, i);
                String content = cell.getContents();
                if (j == 0) {
                    student.setId(content);
                } else if (j == 1) {
                    student.setName(content);
                } else if (cell.getType() == CellType.EMPTY) {
                    flag = 1;
                    break;
                } else {
                    Score score = new Score();
                    score.setCourseName(sheet.getCell(j, 0).getContents());
                    score.setCourseScore(Double.parseDouble(content));
                    scoreList.add(score);
                }
            //    System.out.print(content + " ");
            }
            if (flag == 1) break;
            student.setScoreList(scoreList);
            studentList.add(student);
           // System.out.println();
        }
        //最后一步：关闭资源
        workbook.close();
        return studentList;
    }

}
