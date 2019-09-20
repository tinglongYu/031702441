package addressbook;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Citysearch {
    public static final String[] MyProvince = {"内蒙古自治区","广西壮族自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区","北京","天津","上海","重庆","河北","山西","辽宁","吉林","黑龙江","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东","海南","四川","贵州","云南","陕西","甘肃","青海","内蒙古","广西","西藏","宁夏","新疆"};
    public static final String[] MyCity = {

            "阿坝","阿拉善","阿里","安康","安庆","鞍山","安顺","安阳","澳门","B","北京","白银",

            "保定","宝鸡","保山","包头","巴中","北海","蚌埠","本溪","毕节","滨州","百色","亳州",

            "重庆","成都","长沙","长春","沧州","常德","昌都","长治","常州","巢湖","潮州","承德",

            "郴州","赤峰","池州","崇左","楚雄","滁州","朝阳","大连","东莞","大理","丹东","大庆",

            "大同","大兴安岭","德宏","德阳","德州","定西","迪庆","东营","鄂尔多斯","恩施","鄂州",

            "福州","防城港","佛山","抚顺","抚州","阜新","阜阳","广州","桂林","贵阳","甘南",

            "赣州","甘孜","广安","广元","贵港","果洛","杭州","哈尔滨","合肥","海口","呼和浩特",

            "海北","海东","海南","海西","邯郸","汉中","鹤壁","河池","鹤岗","黑河","衡水","衡阳",

            "河源","贺州","红河","淮安","淮北","怀化","淮南","黄冈","黄南","黄山","黄石","惠州",

            "葫芦岛","呼伦贝尔","湖州","菏泽","济南","佳木斯","吉安","江门","焦作","嘉兴","嘉峪关",

            "揭阳","吉林","金昌","晋城","景德镇","荆门","荆州","金华","济宁","晋中","锦州","九江",

            "酒泉","昆明","开封","兰州","拉萨","来宾","莱芜","廊坊","乐山","凉山","连云港",

            "聊城","辽阳","辽源","丽江","临沧","临汾","临夏","临沂","林芝","丽水","六安","六盘水",

            "柳州","陇南","龙岩","娄底","漯河","洛阳","泸州","吕梁","马鞍山","茂名","眉山","梅州",

            "绵阳","牡丹江","南京","南昌","南宁","宁波","南充","南平","南通","南阳","那曲","内江",

            "宁德","怒江","盘锦","攀枝花","平顶山","平凉","萍乡","莆田","濮阳","青岛","黔东南",

            "黔南","黔西南","庆阳","清远","秦皇岛","钦州","齐齐哈尔","泉州","曲靖","衢州","日喀则",

            "日照","上海","深圳","苏州","沈阳","石家庄","三门峡","三明","三亚","商洛","商丘","上饶",

            "山南","汕头","汕尾","韶关","绍兴","邵阳","十堰","朔州","四平","绥化","遂宁","随州","宿迁",

            "宿州","天津","太原","泰安","泰州","台州","唐山","天水","铁岭","铜川","通化","通辽",

            "铜陵","铜仁","台湾","武汉","乌鲁木齐","无锡","威海","潍坊","文山","温州","乌海","芜湖",

            "乌兰察布","武威","梧州","厦门","西安","西宁","襄樊","湘潭","湘西","咸宁","咸阳","孝感",

            "邢台","新乡","信阳","新余","忻州","西双版纳","宣城","许昌","徐州","香港","锡林郭勒","兴安",

            "银川","雅安","延安","延边","盐城","阳江","阳泉","扬州","烟台","宜宾","宜昌","宜春",

            "营口","益阳","永州","岳阳","榆林","运城","云浮","玉树","玉溪","玉林",

            "枣庄","扎赉特旗",

            "扎鲁特旗","张家港","张家界","张家口",

            "张掖","漳州","湛江",

            "肇庆","昭通",

            "郑州","镇海区","镇江",

            "中山",

            "中卫","舟山",

            "珠海","驻马店","准格尔旗","卓尼",

            "株洲","淄博","自贡",

            "资阳"

    };
    private static final String[] thirdadress={"县","区","市"};
    private static final String[] forthadress={"街道","镇","乡"};
    private static final String[] fifthadress={"路","街","巷"};
    /*查找地址中的省份信息*/
    private static int MatchProvince(String str){
        for(int i=0;i<MyProvince.length;i++){
            if(str.contains(MyProvince[i]))
                return i;
        }
        return -1;
    }
    
    /*查找地址中的地级市信息*/
    private static int MatchCity(String str){
        for(int i=0;i<MyCity.length;i++){
            if(str.contains(MyCity[i]))
                return i;
        }
        return -1;
    }
    
    /*查找三级地址关键词*/
    private static int MatchThirdaddress(String str){
        for(int i=0;i<thirdadress.length;i++){
            if(str.contains(thirdadress[i]))
                return i;
        }
        return -1;
    }
    
    /*查找四级地址关键词*/
    private static int MatchForthaddress(String str){
        for(int i=0;i<forthadress.length;i++){
            if(str.contains(forthadress[i]))
                return i;
        }
        return -1;
    }
    
    /*查找五级地址关键词*/
    private static int MatchFifthaddress(String str){
        for(int i=0;i<fifthadress.length;i++){
            if(str.contains(fifthadress[i]))
                return i;
        }
        return -1;
    }
    
    /*将指定字符串划分出姓名手机号和五级地址*/
    private static String[] Fivelevel(String str){
        String NewAddress[] = new String[10];//用于存储划分出来的各项信息
        str=str.substring(2,str.length());//去除标志信息
        String[] firstArray=str.split(",",2);//将姓名与其他信息分隔
        NewAddress[0]=firstArray[0];
        str=firstArray[1];//获得去除姓名后的字符串
        int location;//记录关键信息在信息数组中的位置
        int flag1;//记录关键信息在字符串中的位置
        
        String regex="\\d{11}";//手机号正则表达式
        Pattern pattern = Pattern.compile(regex);
        // 创建匹配给定输入与此模式的匹配器。
        Matcher matcher = pattern.matcher(str);
        //查找字符串中是否有符合的子字符串
        while(matcher.find()){
            //查找到符合的即输出
            NewAddress[1]=matcher.group();//获取手机号
        }
        firstArray=str.split(regex,2);//以手机号为标志分隔字符串
        str=firstArray[0]+firstArray[1];//得到去除手机号后的字符串
        
        /*提取省份信息后删除省份信息*/
        location=MatchProvince(str);
        if(location==-1) {
        	NewAddress[2]="";
        }
        else {
        	NewAddress[2]=MyProvince[location];
            flag1=str.indexOf(MyProvince[location]);
            if(location!=1 && location!=2 && location!=0 && location!=3&&location!=4 && location!=5 && location!=6 && location!=7&&location!=8){
                NewAddress[2]=MyProvince[location]+"省";
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
        /*提取地级市信息后删除地级市信息*/
        location=MatchCity(str);
        if(location==-1){
            NewAddress[3]="";
        }
        else{
            flag1=str.indexOf(MyCity[location]);
            NewAddress[3]=MyCity[location]+"市";
            if(str.substring(flag1,flag1+MyCity[location].length()+1).equals(NewAddress[3])){
                str=str.substring(flag1+MyCity[location].length()+1,str.length());
            }
            else{
                str=str.substring(flag1+MyCity[location].length(),str.length());
            }
        }
        /*提取三级地址信息后删除三级地址信息*/
        location=MatchThirdaddress(str);
        if(location==-1){
            NewAddress[4]="";
        }
        else{
            flag1=str.indexOf(thirdadress[location]);
            NewAddress[4]=str.substring(0,flag1+1);
            str=str.substring(flag1+1,str.length());
        }
        /*提取四级地址信息后删除四级地址信息*/
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

        NewAddress[6]=str;//剩下的字符串就是详细地址
        return NewAddress;
    }
    
    /*字符串修复方法*/
    public static String[] Addressfix(String str){
        String NewAddress[];
        String flag;
        flag = str.substring(0,2);//获取难度标志信息
        /*一级难度直接调用Fivelevel()方法*/
        if(flag.equals("1!")){
            NewAddress=Fivelevel(str);
            NewAddress[9]=flag;
            return NewAddress;
        }
        /*二级难度只需在一级难度上再查找两次关键地址信息，放弃做附加题，所以附加题也采用二级难度的方法*/
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

            flag1=str.indexOf("号");
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
