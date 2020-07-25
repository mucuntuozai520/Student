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
    private  int HEADERNUM;//����ͷ����
    private final static String excel2003L =".xls";    //2003- �汾��excel  
    private final static String excel2007U =".xlsx";   //2007+ �汾��excel  
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
     * �����������ļ���׺������Ӧ�ϴ��ļ��İ汾  
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
            throw new Exception("�������ļ���ʽ����");  
        }  
        return wb;  
    }  
  
    /** 
     * �������Ա������ֵ���и�ʽ�� 
     * @param cell 
     * @return 
     */  
    public  Object getCellValue(Cell cell){  
        Object value = null;  
        DecimalFormat df = new DecimalFormat("0");  //��ʽ��number String�ַ�  
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //���ڸ�ʽ��  
        DecimalFormat df2 = new DecimalFormat("0.00");  //��ʽ������  
          
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
     *  ��ȡexcel���ݱ��List<BookInfo>����
     * */
    public List<Student> ExcelData(String fileName) {	
    	     HEADERNUM=1;
			ArrayList<Student> dataList = new ArrayList<Student>();	
			 Sheet sheet = null; 
			 //����Excel������  
	            try {
	            	String fileName1="D:\\java se\\Student\\WebContent\\upload\\"+fileName;
	            	FileInputStream in=new FileInputStream(fileName1);
	            	Workbook workbook = this.getWorkbook(in,fileName);  
	            	SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");//MM��д��ʾ�£������ʾ��
	      	        if(null != workbook){  
	      	        	sheet = workbook.getSheetAt(0);//��ȡ ��һ��sheet
	     int maxrow = sheet.getLastRowNum();//��������ʵ�ʵ�excel������һ���Ƿ��Ǽ�¼
for (int i = HEADERNUM; i <= maxrow; i++)// ѭ��ȡ�������У�����ǰHEADERNUM�б���ͷ
						{
	      	        		Row aRow = sheet.getRow(i);//ÿ������
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
	      	      	throw new Exception("����Excel������Ϊ�գ�");
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
    	if (fileType.equals("xls")) {  //�ļ�����
    		workbook = new HSSFWorkbook();  
    	}  
    	else if(fileType.equals("xlsx"))  
    	{  
    		workbook = new XSSFWorkbook();  
    	}  
    	try {
    		Sheet sheet = workbook.createSheet("ѧ����Ϣ");//����һ���������ı�
    		int colum;//EXCEL��������
    		Row row = null;//��
    		Cell cell = null;//��Ԫ��
    		String heads[] = {"id","name","age","address","birtday","date"};
    		row = sheet.createRow(HEADERNUM-1);//����һ���ж���
    		for(int i=0;i<heads.length;i++){//����Excel���ĵ�һ�м�����
    			cell = row.createCell(i);//������Ԫ��
    			//cell.setCellStyle(style);//���õ�Ԫ����
    			cell.setCellValue(heads[i]);//���õ�Ԫ���ֵ
    		}
    		int i=0;
    		for (Student stu:list)//����list����
    		{
    			row = sheet.createRow(i+HEADERNUM);//����һ���ж���
    			if (row != null) {
    				colum = 0;
    				Cell id = row.createCell(colum++);//ͼ����
    				Cell name = row.createCell(colum++);//������
    				Cell age = row.createCell(colum++);//�۸�
    				Cell address = row.createCell(colum++);//����ʱ��
    				Cell birthday = row.createCell(colum++);//���ʱ��
    				Cell date = row.createCell(colum++);
    				if(null!=id)id.setCellValue(stu.getId());
    				if(null!=name)name.setCellValue(stu.getName());
    				if(null!=age)age.setCellValue(stu.getAge());//���õ�Ԫ������
    				if(null!=address)address.setCellValue(stu.getAddress());
    				if(null!=birthday)birthday.setCellValue(stu.getTime2());
    				if(null!=date)date.setCellValue(stu.getTime1());
    				i++;
    			}
    		}
    	}catch (Exception e) {
    	      log.error("����EXCEL����ʧ��", e);
    	      e.printStackTrace();
    		}
    	return workbook;
}

}
