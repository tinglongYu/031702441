package Homework1;
public class Main {

	public static void main(String[] args) {
		MultNomial YourMultNomial = new MultNomial("y=-3x^4+2x^-3+2x-x^3+x^-3+x+3", 2);
		System.out.println("answer:" + YourMultNomial.CaculateResult());
		System.out.println("导数为：" + YourMultNomial.GetDerivative());
	}
}
