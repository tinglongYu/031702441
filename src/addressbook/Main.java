package addressbook;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static Collection<String> damagedAddressBook = new ArrayList<String>();//用于存储每一条原始地址信息
    public static void main(String[] args) throws IOException {
    	/*文件输入部分*/
        String inputpath=args[0];
        String outputpath=args[1];//获取输入输出文件参数
        FileInputStream fis = new FileInputStream(inputpath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            damagedAddressBook.add(line);
        }
        /*原始地址处理和输出部分*/
        int number=damagedAddressBook.size();
        int count=0;//每输出一一条地址count就加一，用来判断是不是最后一次输出
        Iterator<String> it =damagedAddressBook.iterator();//创建迭代器
        String NewAddress[];//用来存储处理好的地址信息
        FileOutputStream fos = new FileOutputStream(outputpath);
        @SuppressWarnings("resource")
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write("[");
        osw.flush();
        while (it.hasNext()){//开始迭代
            String str =it.next();
            NewAddress=Citysearch.Addressfix(str);//获取一条处理好的地址信息
            /*按规定格式输出*/
            if(NewAddress[9].equals("1!")){
                count++;
                if(count!=number){
                    osw.write("{\"姓名\":"+"\""+NewAddress[0]+"\","+"\"手机\":"+"\""+NewAddress[1]+"\","+"\"地址\":"+"["
                            +"\""+NewAddress[2]+"\","+"\""+NewAddress[3]+"\","+"\""+NewAddress[4]+"\","+"\""+NewAddress[5]+"\","
                            +"\""+NewAddress[6]+"\"]},\r\n");
                    osw.flush();
                }
                else{
                    osw.write("{\"姓名\":"+"\""+NewAddress[0]+"\","+"\"手机\":"+"\""+NewAddress[1]+"\","+"\"地址\":"+"["
                            +"\""+NewAddress[2]+"\","+"\""+NewAddress[3]+"\","+"\""+NewAddress[4]+"\","+"\""+NewAddress[5]+"\","
                            +"\""+NewAddress[6]+"\"]}]");
                    osw.flush();
                }
            }
            else{
                count++;
                if(count!=number){
                    osw.write("{\"姓名\":"+"\""+NewAddress[0]+"\","+"\"手机\":"+"\""+NewAddress[1]+"\","+"\"地址\":"+"["
                            +"\""+NewAddress[2]+"\","+"\""+NewAddress[3]+"\","+"\""+NewAddress[4]+"\","+"\""+NewAddress[5]+"\","
                            +"\""+NewAddress[6]+"\","+"\""+NewAddress[7]+"\","+"\""+NewAddress[8]+"\"]},\r\n");
                    osw.flush();
                }
                else{
                    osw.write("{\"姓名\":"+"\""+NewAddress[0]+"\","+"\"手机\":"+"\""+NewAddress[1]+"\","+"\"地址\":"+"["
                            +"\""+NewAddress[2]+"\","+"\""+NewAddress[3]+"\","+"\""+NewAddress[4]+"\","+"\""+NewAddress[5]+"\","
                            +"\""+NewAddress[6]+"\","+"\""+NewAddress[7]+"\","+"\""+NewAddress[8]+"\"]}]");
                    osw.flush();
                }
            }
        }
    }
}
