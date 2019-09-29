package Homework1;
/*该类与MultNomial类为组合关系，所有的子项都不带符号，Transform()方法提取项的常数部分、指数部分并判断是否有x，
Calculate()计算项的值（不含符号），GetDerivative()计算项的导数（不含符号），添加符号的操作都在MultNomial类
中完成。
*/
public class Nomial {
    private String item;
    private double X;
    //构造函数
    public Nomial(String str,double x){
        this.item=str;
        this.X=x;
    }

    //提取项的常数部分、指数部分并判断是否有x
    private int[] Transform(){
        int[] numbers={1,0,0};
        if(item.indexOf("x")==-1){
            item=item.trim();
            numbers[0]=Integer.parseInt(item);
        }
        else {
            int flag=item.indexOf("x");
            if(item.length()==flag+1){
                String temp=item.substring(0,flag);
                if(flag==0) numbers[0]=1;
                else
                    numbers[0]=Integer.parseInt(temp);
                numbers[1]=1;
                numbers[2]=1;
            }
            else{
                String temp1=item.substring(0,flag);
                String temp2=item.substring(flag+2,item.length());
                if(flag==0) numbers[0]=1;
                else
                    numbers[0]=Integer.parseInt(temp1);
                numbers[1]=1;
                if(temp2.indexOf('_')==-1) {
                    numbers[2]=Integer.parseInt(temp2);
                }
                else{
                    temp2=temp2.substring(1,temp2.length());
                    numbers[2]=-Integer.parseInt(temp2);
                }
            }
        }
        return numbers;
    }

    //计算项的值（不含符号）
    public double Calculate(){
        double answer=0;
        int[] numbers=Transform();
        if(numbers[1]==0){
            answer+=(double)numbers[0];
        }
        else{
            answer+=numbers[0]*Math.pow(X,numbers[2]);
        }
        return answer;
    }

    //计算项的导数（不含符号）
    public String GetDerivative(){
        int[] numbers=Transform();
        String Derivative="";
        if(numbers[1]==1){
             numbers[0]*=numbers[2];
             numbers[2]-=1;
             if(numbers[2]!=0)
                 Derivative=numbers[0]+"x^"+numbers[2];
             else
                 Derivative=String.valueOf(numbers[0]);
        }
        return Derivative;
    }
}
