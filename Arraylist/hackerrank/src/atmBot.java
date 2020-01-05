/**
 * Created by Sharath Nagendra on 3/15/2018.
 */
public class atmBot {
    static int[] getState(int[] accounts,String[] requests){

        for(int i=0;i<requests.length;i++)
        {
            String temp = requests[i];
            String tempArr[] = temp.split(" ");

            if(accounts.length==1 && tempArr[0].equals("transfer"))
                return new int[]{-i-1};

            if(tempArr[0].equals("withdraw")){
                int accNum = Integer.parseInt(tempArr[1])-1;
                if(accounts[accNum]-Integer.parseInt(tempArr[2])>=0)
                 accounts[accNum] = accounts[accNum]-Integer.parseInt(tempArr[2]);
                else
                    continue;
               // printAccount(accounts);

            }

            else if(tempArr[0].equals("transfer")){
                int accNumFrom = Integer.parseInt(tempArr[1])-1;
                int accNumTo = Integer.parseInt(tempArr[2])-1;
                if(accounts[accNumFrom]-Integer.parseInt(tempArr[3])<0 )
                    return new int[]{-i-1};
                    //continue;
               // accounts[accNumFrom]=accounts[accNumFrom]-Integer.parseInt(tempArr[3]);
                accounts[accNumTo]+=Integer.parseInt(tempArr[3]);

               // printAccount(accounts);
            }

            else if(tempArr[0].equals("deposit")){
                int accNum = Integer.parseInt(tempArr[1])-1;
                accounts[accNum] = accounts[accNum]+Integer.parseInt(tempArr[2]);
               // printAccount(accounts);

            }
            else
            {
                return new int[]{-i};
            }


        }
        return accounts;
    }

    static void printAccount(int[] accounts){
        for(int i=0;i<accounts.length;i++)
            System.out.println("State of account is "+accounts[i]);
    }

    public static void main(String[] args) {
        int[] acc = {42};
        String[] requests = {"transfer 1 2 3"};

        int[] res =getState(acc,requests);

        for(int i:res)
            System.out.println(i);
    }
}
