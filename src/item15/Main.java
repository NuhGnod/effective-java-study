package item15;

public class Main extends Thread{
    public static void main(String[] args) {
//        Account account = new Account();
//
//        for(int i=0; i<10; i++) {
//            Thread deposit = new Thread(new DepositThread(account));
//            Thread withdraw = new Thread(new WithdrawThread(account));
//            deposit.start();
//            withdraw.start();
//        }
        int [] array = {1,2,3,4,5};
        PublicFinalArray pfArray = new PublicFinalArray(array);
        System.out.println(pfArray);
        int[] newArray = new int[5]     ;
//        pfArray.array = newArray; // final키워드로 인해 재할당 불가.
        int[] get = pfArray.getArray();
        get[0] = -1;
        get[1] = -2;
        get[2] = -3;
        get[3] = -4;
        get[4] = -5;
        System.out.println(pfArray);
    }
}

