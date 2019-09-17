package addressbook;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static Collection<String> damagedAddressBook = new ArrayList<String>();//���ڴ洢ÿһ��ԭʼ��ַ��Ϣ
    public static void main(String[] args) throws IOException {
    	/*�ļ����벿��*/
        String inputpath=args[0];
        String outputpath=args[1];//��ȡ��������ļ�����
        FileInputStream fis = new FileInputStream(inputpath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            damagedAddressBook.add(line);
        }
        /*ԭʼ��ַ������������*/
        int number=damagedAddressBook.size();
        int count=0;//ÿ���һһ����ַcount�ͼ�һ�������ж��ǲ������һ�����
        Iterator<String> it =damagedAddressBook.iterator();//����������
        String NewAddress[];//�����洢����õĵ�ַ��Ϣ
        FileOutputStream fos = new FileOutputStream(outputpath);
        @SuppressWarnings("resource")
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write("[");
        osw.flush();
        while (it.hasNext()){//��ʼ����
            String str =it.next();
            NewAddress=Citysearch.Addressfix(str);//��ȡһ������õĵ�ַ��Ϣ
            /*���涨��ʽ���*/
            if(NewAddress[9].equals("1!")){
                count++;
                if(count!=number){
                    osw.write("{\"����\":"+"\""+NewAddress[0]+"\","+"\"�ֻ�\":"+"\""+NewAddress[1]+"\","+"\"��ַ\":"+"["
                            +"\""+NewAddress[2]+"\","+"\""+NewAddress[3]+"\","+"\""+NewAddress[4]+"\","+"\""+NewAddress[5]+"\","
                            +"\""+NewAddress[6]+"\"]},\r\n");
                    osw.flush();
                }
                else{
                    osw.write("{\"����\":"+"\""+NewAddress[0]+"\","+"\"�ֻ�\":"+"\""+NewAddress[1]+"\","+"\"��ַ\":"+"["
                            +"\""+NewAddress[2]+"\","+"\""+NewAddress[3]+"\","+"\""+NewAddress[4]+"\","+"\""+NewAddress[5]+"\","
                            +"\""+NewAddress[6]+"\"]}]");
                    osw.flush();
                }
            }
            else{
                count++;
                if(count!=number){
                    osw.write("{\"����\":"+"\""+NewAddress[0]+"\","+"\"�ֻ�\":"+"\""+NewAddress[1]+"\","+"\"��ַ\":"+"["
                            +"\""+NewAddress[2]+"\","+"\""+NewAddress[3]+"\","+"\""+NewAddress[4]+"\","+"\""+NewAddress[5]+"\","
                            +"\""+NewAddress[6]+"\","+"\""+NewAddress[7]+"\","+"\""+NewAddress[8]+"\"]},\r\n");
                    osw.flush();
                }
                else{
                    osw.write("{\"����\":"+"\""+NewAddress[0]+"\","+"\"�ֻ�\":"+"\""+NewAddress[1]+"\","+"\"��ַ\":"+"["
                            +"\""+NewAddress[2]+"\","+"\""+NewAddress[3]+"\","+"\""+NewAddress[4]+"\","+"\""+NewAddress[5]+"\","
                            +"\""+NewAddress[6]+"\","+"\""+NewAddress[7]+"\","+"\""+NewAddress[8]+"\"]}]");
                    osw.flush();
                }
            }
        }
    }
}
