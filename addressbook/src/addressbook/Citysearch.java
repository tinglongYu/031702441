package addressbook;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Citysearch {
    public static final String[] MyProvince = {"���ɹ�������","����׳��������","����������","���Ļ���������","�½�ά���������","����","���","�Ϻ�","����","�ӱ�","ɽ��","����","����","������","����","�㽭","����","����","����","ɽ��","����","����","����","�㶫","����","�Ĵ�","����","����","����","����","�ຣ","���ɹ�","����","����","����","�½�"};
    public static final String[] MyCity = {

            "����","������","����","����","����","��ɽ","��˳","����","����","B","����","����",

            "����","����","��ɽ","��ͷ","����","����","����","��Ϫ","�Ͻ�","����","��ɫ","����",

            "����","�ɶ�","��ɳ","����","����","����","����","����","����","����","����","�е�",

            "����","���","����","����","����","����","����","����","��ݸ","����","����","����",

            "��ͬ","���˰���","�º�","����","����","����","����","��Ӫ","������˹","��ʩ","����",

            "����","���Ǹ�","��ɽ","��˳","����","����","����","����","����","����","����",

            "����","����","�㰲","��Ԫ","���","����","����","������","�Ϸ�","����","���ͺ���",

            "����","����","����","����","����","����","�ױ�","�ӳ�","�׸�","�ں�","��ˮ","����",

            "��Դ","����","���","����","����","����","����","�Ƹ�","����","��ɽ","��ʯ","����",

            "��«��","���ױ���","����","����","����","��ľ˹","����","����","����","����","������",

            "����","����","���","����","������","����","����","��","����","����","����","�Ž�",

            "��Ȫ","����","����","����","����","����","����","�ȷ�","��ɽ","��ɽ","���Ƹ�",

            "�ĳ�","����","��Դ","����","�ٲ�","�ٷ�","����","����","��֥","��ˮ","����","����ˮ",

            "����","¤��","����","¦��","���","����","����","����","��ɽ","ï��","üɽ","÷��",

            "����","ĵ����","�Ͼ�","�ϲ�","����","����","�ϳ�","��ƽ","��ͨ","����","����","�ڽ�",

            "����","ŭ��","�̽�","��֦��","ƽ��ɽ","ƽ��","Ƽ��","����","���","�ൺ","ǭ����",

            "ǭ��","ǭ����","����","��Զ","�ػʵ�","����","�������","Ȫ��","����","����","�տ���",

            "����","�Ϻ�","����","����","����","ʯ��ׯ","����Ͽ","����","����","����","����","����",

            "ɽ��","��ͷ","��β","�ع�","����","����","ʮ��","˷��","��ƽ","�绯","����","����","��Ǩ",

            "����","���","̫ԭ","̩��","̩��","̨��","��ɽ","��ˮ","����","ͭ��","ͨ��","ͨ��",

            "ͭ��","ͭ��","̨��","�人","��³ľ��","����","����","Ϋ��","��ɽ","����","�ں�","�ߺ�",

            "�����첼","����","����","����","����","����","�差","��̶","����","����","����","Т��",

            "��̨","����","����","����","����","��˫����","����","���","����","���","���ֹ���","�˰�",

            "����","�Ű�","�Ӱ�","�ӱ�","�γ�","����","��Ȫ","����","��̨","�˱�","�˲�","�˴�",

            "Ӫ��","����","����","����","����","�˳�","�Ƹ�","����","��Ϫ","����",

            "��ׯ","��������",

            "��³����","�żҸ�","�żҽ�","�żҿ�",

            "��Ҵ","����","տ��",

            "����","��ͨ",

            "֣��","����","��",

            "��ɽ",

            "����","��ɽ",

            "�麣","פ���","׼�����","׿��",

            "����","�Ͳ�","�Թ�",

            "����"

    };
    private static final String[] thirdadress={"��","��","��"};
    private static final String[] forthadress={"�ֵ�","��","��"};
    private static final String[] fifthadress={"·","��","��"};
    /*���ҵ�ַ�е�ʡ����Ϣ*/
    private static int MatchProvince(String str){
        for(int i=0;i<MyProvince.length;i++){
            if(str.contains(MyProvince[i]))
                return i;
        }
        return -1;
    }
    
    /*���ҵ�ַ�еĵؼ�����Ϣ*/
    private static int MatchCity(String str){
        for(int i=0;i<MyCity.length;i++){
            if(str.contains(MyCity[i]))
                return i;
        }
        return -1;
    }
    
    /*����������ַ�ؼ���*/
    private static int MatchThirdaddress(String str){
        for(int i=0;i<thirdadress.length;i++){
            if(str.contains(thirdadress[i]))
                return i;
        }
        return -1;
    }
    
    /*�����ļ���ַ�ؼ���*/
    private static int MatchForthaddress(String str){
        for(int i=0;i<forthadress.length;i++){
            if(str.contains(forthadress[i]))
                return i;
        }
        return -1;
    }
    
    /*�����弶��ַ�ؼ���*/
    private static int MatchFifthaddress(String str){
        for(int i=0;i<fifthadress.length;i++){
            if(str.contains(fifthadress[i]))
                return i;
        }
        return -1;
    }
    
    /*��ָ���ַ������ֳ������ֻ��ź��弶��ַ*/
    private static String[] Fivelevel(String str){
        String NewAddress[] = new String[10];//���ڴ洢���ֳ����ĸ�����Ϣ
        str=str.substring(2,str.length());//ȥ����־��Ϣ
        String[] firstArray=str.split(",",2);//��������������Ϣ�ָ�
        NewAddress[0]=firstArray[0];
        str=firstArray[1];//���ȥ����������ַ���
        int location;//��¼�ؼ���Ϣ����Ϣ�����е�λ��
        int flag1;//��¼�ؼ���Ϣ���ַ����е�λ��
        
        String regex="\\d{11}";//�ֻ���������ʽ
        Pattern pattern = Pattern.compile(regex);
        // ����ƥ������������ģʽ��ƥ������
        Matcher matcher = pattern.matcher(str);
        //�����ַ������Ƿ��з��ϵ����ַ���
        while(matcher.find()){
            //���ҵ����ϵļ����
            NewAddress[1]=matcher.group();//��ȡ�ֻ���
        }
        firstArray=str.split(regex,2);//���ֻ���Ϊ��־�ָ��ַ���
        str=firstArray[0]+firstArray[1];//�õ�ȥ���ֻ��ź���ַ���
        
        /*��ȡʡ����Ϣ��ɾ��ʡ����Ϣ*/
        location=MatchProvince(str);
        if(location==-1) {
        	NewAddress[2]="";
        }
        else {
        	NewAddress[2]=MyProvince[location];
            flag1=str.indexOf(MyProvince[location]);
            if(location!=1 && location!=2 && location!=0 && location!=3&&location!=4 && location!=5 && location!=6 && location!=7&&location!=8){
                NewAddress[2]=MyProvince[location]+"ʡ";
                if(str.substring(flag1,flag1+MyProvince[location].length()+1).equals(NewAddress[2])){
                    str=str.substring(flag1+MyProvince[location].length()+1,str.length());
                }
                else{
                    str=str.substring(flag1+MyProvince[location].length(),str.length());
                }
            }
            else{
                str=str.substring(flag1+MyProvince[location].length(),str.length());
            }
        }
        /*��ȡ�ؼ�����Ϣ��ɾ���ؼ�����Ϣ*/
        location=MatchCity(str);
        if(location==-1){
            NewAddress[3]="";
        }
        else{
            flag1=str.indexOf(MyCity[location]);
            NewAddress[3]=MyCity[location]+"��";
            if(str.substring(flag1,flag1+MyCity[location].length()+1).equals(NewAddress[3])){
                str=str.substring(flag1+MyCity[location].length()+1,str.length());
            }
            else{
                str=str.substring(flag1+MyCity[location].length(),str.length());
            }
        }
        /*��ȡ������ַ��Ϣ��ɾ��������ַ��Ϣ*/
        location=MatchThirdaddress(str);
        if(location==-1){
            NewAddress[4]="";
        }
        else{
            flag1=str.indexOf(thirdadress[location]);
            NewAddress[4]=str.substring(0,flag1+1);
            str=str.substring(flag1+1,str.length());
        }
        /*��ȡ�ļ���ַ��Ϣ��ɾ���ļ���ַ��Ϣ*/
        location=MatchForthaddress(str);
        if(location==-1){
            NewAddress[5]="";
        }
        else{
            flag1=str.indexOf(forthadress[location]);
            if(location!=0){
                NewAddress[5]=str.substring(0,flag1+1);
                str=str.substring(flag1+1,str.length());
            }
            else{
                NewAddress[5]=str.substring(0,flag1+2);
                str=str.substring(flag1+2,str.length());
            }
        }

        NewAddress[6]=str;//ʣ�µ��ַ���������ϸ��ַ
        return NewAddress;
    }
    
    /*�ַ����޸�����*/
    public static String[] Addressfix(String str){
        String NewAddress[];
        String flag;
        flag = str.substring(0,2);//��ȡ�Ѷȱ�־��Ϣ
        /*һ���Ѷ�ֱ�ӵ���Fivelevel()����*/
        if(flag.equals("1!")){
            NewAddress=Fivelevel(str);
            NewAddress[9]=flag;
            return NewAddress;
        }
        /*�����Ѷ�ֻ����һ���Ѷ����ٲ������ιؼ���ַ��Ϣ�������������⣬���Ը�����Ҳ���ö����Ѷȵķ���*/
        else {
            NewAddress=Fivelevel(str);
            str=NewAddress[6];

            int location=MatchFifthaddress(str);
            int flag1;
            if(location==-1){
                NewAddress[6]="";
            }
            else{
                flag1=str.indexOf(fifthadress[location]);
                NewAddress[6]=str.substring(0,flag1+1);
                str=str.substring(flag1+1,str.length());
            }

            flag1=str.indexOf("��");
            if(flag1==-1){
                NewAddress[7]="";
            }
            else{
                NewAddress[7]=str.substring(0,flag1+1);
                str=str.substring(flag1+1,str.length());
            }
            NewAddress[8]=str;
            NewAddress[9]=flag;
            return NewAddress;
        }
    }
}
