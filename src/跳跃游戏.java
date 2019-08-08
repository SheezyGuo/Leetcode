public class    跳跃游戏 {
    public static int jump(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=3;j++){
                if(i-j>=0){
                    dp[i]+=dp[i-j];
                }
            }
        }
        return dp[n];
    }

    public static int func(int n){
        if(n==0){
            return 1;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        return func(n-1)+func(n-2)+func(n-3);
    }

    public static void main(String[] args) {
        System.out.println(func(1));
        System.out.println(func(2));
        System.out.println(func(3));
        System.out.println(func(4));
        System.out.println(func(5));
    }
}
