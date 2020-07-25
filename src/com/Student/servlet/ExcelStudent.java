package com.Student.servlet;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import cn.Model.haha.Student;

public class ExcelStudent {
    private static Logger log = Logger.getLogger(ExcelStudent.class.getName());
    private static ExcelStudent _instance = null;
    private  int HEADERNUM;//标题头行数
    private final static String excel2003L =".xls";    //2003- 版本的excel  
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel  
    private ExcelStudent(){}
    public static ExcelStudent getInstance()
    {
        if (null==_instance)
        {
            _instance = new ExcelStudent();
        }
        return _instance;
    }
    /** 
     * 描述：根据文件后缀，自适应上传文件的版本  
     * @param inStr,fileName 
     * @return 
     * @throws Exception 
     */  
    public  Workbook getWorkbook(InputStream inStr,String fileName) throws Exception{  
        Workbook wb = null;  
        String fileType = fileName.substring(fileName.lastIndexOf("."));  
        if(excel2003L.equals(fileType)){  
            wb = new HSSFWorkbook(inStr);  //2003-  
        }else if(excel2007U.equals(fileType)){  
            wb = new XSSFWorkbook(inStr);  //2007+  
        }else{  
            throw new Exception("解析的文件格式有误！");  
        }  
        return wb;  
    }  
  
    /** 
     * 描述：对表格中数值进行格式化 
     * @param cell 
     * @return 
     */  
    public  Object getCellValue(Cell cell){  
        Object value = null;  
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符  
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化  
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字  
          
        switch (cell.getCellType()) {  
        case Cell.CELL_TYPE_STRING:  
            value = cell.getRichStringCellValue().getString();  
            break;  
        case Cell.CELL_TYPE_NUMERIC:  
            if("General".equals(cell.getCellStyle().getDataFormatString())){  
                value = df.format(cell.getNumericCellValue());  
            }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){  
                value = sdf.format(cell.getDateCellValue());  
            }else{  
                value = df2.format(cell.getNumericCellValue());  
            }  
            break;  
        case Cell.CELL_TYPE_BOOLEAN:  
            value = cell.getBooleanCellValue();  
            break;  
        case Cell.CELL_TYPE_BLANK:  
            value = "";  
            break;  
        default:  
            break;  
        }  
        return value;  
    } 
    /*
     *  读取excel数据变成List<BookInfo>集合
     * */
    public List<Student> ExcelData(String fileName) {	
    	     HEADERNUM=1;
			ArrayList<Student> dataList = new ArrayList<Student>();	
			 Sheet sheet = null; 
			 //创建Excel工作薄  
	            try {
	            	String fileName1="D:\\java se\\Student\\WebContent\\upload\\"+fileName;
	            	FileInputStream in=new FileInputStream(fileName1);
	            	Workbook workbook = this.getWorkbook(in,fileName);  
	            	SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");//MM大写表示月，否则表示分
	      	        if(null != workbook){  
	      	        	sheet = workbook.getSheetAt(0);//读取 第一个sheet
	     int maxrow = sheet.getLastRowNum();//行数：看实际的excel表格最后一行是否是记录
for (int i = HEADERNUM; i <= maxrow; i++)// 循环取得所有行，不读前HEADERNUM行标题头
						{
	      	        		Row aRow = sheet.getRow(i);//每行数据
							if (aRow != null) {
								Cell id = aRow.getCell(0);//bookName
								Cell name = aRow.getCell(1);//publisher
								Cell age  = aRow.getCell(2);//price
								Cell address = aRow.getCell(3);//pubdate
								Cell time2  = aRow.getCell(4);//rk_time
								Student entity=new Student();
								String trim = id.toString().trim();
								int a=trim.indexOf(".");
								String trim2 = age.toString().trim();
								int b = trim2.indexOf(".");
								String age1 = trim2.substring(0, b);
								int age2 = Integer.parseInt(age1);
								String id1 = trim.substring(0, a);
								int id2 = Integer.parseInt(id1);
								entity.setId(id2);
								entity.setName(name.toString().trim());
								entity.setAge(age2);
								entity.setAddress(address.toString().trim());
								entity.setName(name.toString().trim());
								entity.setAddress(address.toString().trim());
								entity.setTime2(df1.format(time2.getDateCellValue()));
								//System.out.println(entity.toString());
								dataList.add(entity);
							}
						}
	      	        }else {
	      	      	throw new Exception("创建Excel工作薄为空！");
	      	        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   	       	        
			return dataList;
			
    }
    public Workbook DataToExcel(List<Student> list,String fileType) {
    	HEADERNUM=1;
    	Workbook workbook = null;  
    	if (fileType.equals("xls")) {  //文件类型
    		workbook = new HSSFWorkbook();  
    	}  
    	else if(fileType.equals("xlsx"))  
    	{  
    		workbook = new XSSFWorkbook();  
    	}  
    	try {
    		Sheet sheet = workbook.createSheet("学生信息");//创建一个工作薄的表单
    		int colum;//EXCEL表格的列数
    		Row row = null;//行
    		Cell cell = null;//单元格
    		String heads[] = {"id","name","age","address","birtday","date"};
    		row = sheet.createRow(HEADERNUM-1);//创建一个行对象
    		for(int i=0;i<heads.length;i++){//创建Excel表格的第一行即标题
    			cell = row.createCell(i);//创建单元格
    			//cell.setCellStyle(style);//设置单元格风格
    			cell.setCellValue(heads[i]);//设置单元格的值
    		}
    		int i=0;
    		for (Student stu:list)//遍历list集合
    		{
    			row = sheet.createRow(i+HEADERNUM);//创建一个行对象
    			if (row != null) {
    				colum = 0;
    				Cell id = row.createCell(colum++);//图书名
    				Cell name = row.createCell(colum++);//出版社
    				Cell age = row.createCell(colum++);//价格
    				Cell address = row.createCell(colum++);//出版时间
    				Cell birthday = row.createCell(colum++);//入库时间
    				Cell date = row.createCell(colum++);
    				if(null!=id)id.setCellValue(stu.getId());
    				if(null!=name)name.setCellValue(stu.getName());
    				if(null!=age)age.setCellValue(stu.getAge());//设置单元格数据
    				if(null!=address)address.setCellValue(stu.getAddress());
    				if(null!=birthday)birthday.setCellValue(stu.getTime2());
    				if(null!=date)date.setCellValue(stu.getTime1());
    				i++;
    			}
    		}
    	}catch (Exception e) {
    	      log.error("生成EXCEL数据失败", e);
    	      e.printStackTrace();
    		}
    	return workbook;
}

}
