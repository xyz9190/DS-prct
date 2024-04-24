import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Berkeley {
    public static void berkeleyAlgo(String servertime, String time1, String time2) {
        System.out.println("Server Clock   = " + servertime);
        System.out.println("Client Clock 1 = " + time1);
        System.out.println("Client Clock 2 = " + time2);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        try {
            /* Converting time to Milliseconds */
            long s = sdf.parse(servertime).getTime();
            long t1 = sdf.parse(time1).getTime();
            long t2 = sdf.parse(time2).getTime();
            /* Calcuating time differences w.r.t server */
            long st1 = t1 - s;
            System.out.println("time1 - serverTime = "+st1/1000);
            long st2 = t2 - s;
            System.out.println("time2 - serverTime = "+st2/1000);
            /* Fault tolerant Average */
            long aveg = (st1 + st2 + 0) / 3;
            System.out.println("(sterverTime1 + serverTime2 + 0)/3 = "+aveg/1000);
           //System.out.println("The average is:"+aveg);
            /* Adjustment */
            long adjserver = aveg+s;
            long adj_t1 = aveg-st1;
            long adj_t2 = aveg-st2;
            System.out.println("time1 adjustment for clock 1= "+adj_t1/1000);
          System.out.println("time2 adjustment for clock 2 = "+adj_t2/1000);
            /* sync clock */
            System.out.println("Synchronized Server Clock  = "+sdf.format(new Date(adjserver)));
            System.out.println("Synchronized Client 1 Clock = "+sdf.format(new Date(t1+adj_t1)));
            System.out.println("Synchronized Client 2 Clock = "+sdf.format(new Date(t2+adj_t2)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Server Clock Time");
	String T1=sc.nextLine();
	System.out.println("Enter The  Clock 1 Time");
	String T2=sc.nextLine();
	System.out.println("Enter The Cock 2 Time");
	String T3=sc.nextLine();
        berkeleyAlgo(T1, T2, T3);
    }
}






//OUTPUT:	
	
	/*
	it@it-HP-EliteDesk-800-G2-SFF:~/berkeley$ java Berkeley
Enter Server Clock Time
03:00
Enter Clock 1 Time
02:50
Enter Clock 2 Time
03:25
Server Clock   = 03:00
Client Clock 1 = 02:50
Client Clock 2 = 03:25
t1 - s = -10
t2 - s = 25
(st1 + st2 + 0)/3 = 5
t1 adjustment = 15
t2 adjustment = -20
Synchronized Server Clock  = 03:05
Synchronized Client 1 Clock = 03:05
Synchronized Client 2 Clock = 03:05
it@it-HP-EliteDesk-800-G2-SFF:~/berkeley$ 


	
	*/
       
