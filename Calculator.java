import java.util.Scanner;
public class Calculator
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of subjects");
int nofsub=sc.nextInt();
int m[]=new int[nofsub];
float avg;
int i,total=0;
System.out.println("ENTER THE VALUES OF"+nofsub+"subjects");

for (i=0;i<nofsub;i++)
{
m[i]=sc.nextInt();
}
for(i=0;i<nofsub;i++){

total=total+m[i];
}
avg=total/nofsub;

if(avg>=90)
System.out.println("grade = A");
else if(avg<=90 && avg >=80)
System.out.println("grade = B");
else if(avg<=80 && avg >=70)
System.out.println("grade = C");
else if(avg<=70 && avg >=50)
System.out.println("grade = D");
else
System.out.println("grade= F");


System.out.println("Total Marks: " + total);
System.out.println("Average Percentage: " + avg + "%");

}
}





