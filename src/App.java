public class App {
    public static void main(String[] args) throws Exception {
        char[] text = {'A','B','C','D','E','F','G','H','I','J'};
        char[] pattern = {'I', 'I', 'J'};

        int result = search2(text, pattern);

        System.out.println(result);
    }

    // 参考書の関数
    public static int search1(char[] T, char[] P) {
        for(int i=1; i<T.length-P.length+1; i++){
            for(int j=1; j<P.length; j++){
                System.out.println(T[i+j-1] + "と" + P[j] + "の比較をする");
                if(T[i+j-1] == P[j]){
                    if(j == P.length)
                        return i;
                }else{
                    break;
                }
            }
        }
        return -1;  // パターンが見つからない場合は-1を返す
    }

    // 参考書を元に自分で変更した関数
    public static int search2(char[] T, char[] P) {
        for(int i=0; i<T.length-P.length+1; i++){
            for(int j=0; j<P.length; j++){
                System.out.println(T[i+j] + "と" + P[j] + "の比較をする");
                if(T[i+j] == P[j]){
                    if(j == P.length-1)
                        return i+1;
                }else{
                    break;
                }
            }
        }
        return -1;  // パターンが見つからない場合は-1を返す
    }
}
