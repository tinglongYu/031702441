package Homework1;
import java.util.*;
/*解题思路：该类可接受多项式字符串MultNomial和变量X来初始化对象,在构造函数中,利用“+”和“-”作为分隔符
将原始多项式分割为诸多个子项字符串（指数中的负号使用“_”代替来区分）,然后用这些子项字符串来初始化对象集合
Items中的各个Nomial对象。用getsymbol()获取各个子项的符号，用CaculateResult()方法累加所有Items集合
中所有对象返回的值，用GetDerivative()方法将Items集合中所有对象返回的表示子项导数的字符串组合为多项式的
导数。
 */
public class MultNomial {
    private String MutlItem;//多项式的字符串
    private double X;//变量X的值
    private Collection<Nomial> Items = new ArrayList<Nomial>();//存放各个Nomial类的对象，采用组合方式

    //构造函数，包含MutlItem、X、Items中所有对象的初始化
    public MultNomial(String str,double x){
        str=str.substring(2,str.length());//把“y=”去掉
        char[] temp=str.toCharArray();//将字符串转化为字符数组
        for (int i=0;i<temp.length-1;i++)
            if (temp[i] == '^'&&temp[i+1]=='-') {
                temp[i+1]='_';
            }//为了便于用“+”和“-”来分离各个项，先把指数中的“-”用“_”代替
        str= Arrays.toString(temp).replaceAll("[\\[\\]\\s,]", "");//将字符数组转化为字

        this.MutlItem=str;
        this.X=x;

        if(str.indexOf('-')==0) str=str.substring(1,str.length());//为了避免分割后产生空字符串，去除开头的负号

        String[] splitedString=str.split("\\+|\\-");//分割多项式
        //初始化子项对象
        for(int i=0;i<splitedString.length;i++){
            Nomial TempNomial=new Nomial(splitedString[i],x);
            Items.add(TempNomial);
        }
    }

    //获取每个项的符号
    private  int[] getsymbol(){
        int[] symbol = new int[100];
        char[] temp=MutlItem.toCharArray();
        if(temp[0]=='-') symbol[0]=-1;else symbol[0]=1;
        int count=1;
        for (int i=1;i<temp.length;i++){
            if(temp[i]=='-'){
                symbol[count++]=-1;
            }
            if(temp[i]=='+'){
                symbol[count++]=1;
            }
        }
        return symbol;
    }

    //计算多项式的值
    public double CaculateResult(){
        int[] symbols =getsymbol(); //获取各个项的符号
        double answer=0;
        int count=0;//标志算到第几项
        Iterator<Nomial> it=Items.iterator();//创建迭代器
        //给各个子项的值加上符号后累加
        while (it.hasNext()){
            Nomial TempNomial=it.next();
            answer+=symbols[count++]*TempNomial.Calculate();
        }
        return answer;
    }

    //多项式求导，暂时没有考虑导数中多个常数项出现时需要累加起来的情况，即最终求导结果可能为3x+3+2，而不是3x+5.
    public String GetDerivative(){
        String Derivative="";
        int[] symbols =getsymbol();
        int count=0;
        Iterator<Nomial> it=Items.iterator();//创建迭代器
        //开始迭代，给各个子项的导数加上符号后组合成多项式的导数
        while (it.hasNext()){
            int flag1;
            int flag2;//根据flag1和flags的值判断符号怎么加
            Nomial TempNomial=it.next();
            flag1=symbols[count];
            if(TempNomial.GetDerivative().indexOf("-")==0)
                flag2=-1;
            else
                flag2=1;
            if(!TempNomial.GetDerivative().equals("")){
                if(flag1==-1&&flag2==-1)
                    Derivative=Derivative+"+"+TempNomial.GetDerivative().substring(1,TempNomial.GetDerivative().length());
                else if(flag1==-1&&flag2==1){
                    Derivative=Derivative+"-"+TempNomial.GetDerivative();
                }
                else if(flag1==1&&flag2==-1){
                    Derivative=Derivative+TempNomial.GetDerivative();
                }
                else
                    Derivative=Derivative+"+"+TempNomial.GetDerivative();
                count++;
            }
        }
        if(Derivative.equals("")) Derivative=String.valueOf(0);//所有项的导数都为0的特殊情况
        else if(Derivative.indexOf("+")==0){
            Derivative=Derivative.substring(1,Derivative.length());//去除第一项的“+”号
        }
        return Derivative;
    }
}
