public class App {
    public static void main(String[] args) throws Exception {
        char[] text = {'H','I','P','O','P','O','T','A','M','U','S'}; // 元のテキスト
        char[] pattern = {'A','M','U'}; // パターン

        int result1 = search2(text, pattern);
        System.out.println(result1 + "番目の位置で合致しました。");
        int result2 = search3(text, pattern);
        System.out.println(result2 + "番目の位置で合致しました。");
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
        int count = 0;
        for(int i=0; i<T.length-P.length+1; i++){
            for(int j=0; j<P.length; j++){
                System.out.println(T[i+j] + "と" + P[j] + "の比較をする");
                count++;
                if(T[i+j] == P[j]){
                    if(j == P.length-1){
                        System.out.println("比較回数は " + count + "です。");
                        return i+1;
                    }
                }else{
                    break;
                }
            }
        }
        return -1;  // パターンが見つからない場合は-1を返す
    }

    public static int search3(char[] T, char[] P){
        int count = 0;
        int length = checkLength(P);
        char[] C = new char[length];
        int[] D = new int[length];
        for(int x=0; x<length; x++){
            C[x] = ' ';
            D[x] = P.length;
        }

        // System.out.println("C, Dテーブルの初期値");
        // returnTable(C);
        // returnTable(D);

        // 票の作成
        for(int j=0; j < P.length-1; j++){
            for(int k=0; k<=j || k<length; k++){
                if(C[k]==P[j] || C[k]==' '){
                    C[k] = P[j];
                    D[k] = P.length-j-1;
                    break;
                }
            }
        }

        // System.out.println("表の作成後");
        // returnTable(C);
        // returnTable(D);

        // 文字列を照合する
        int i=0;
        int d=0;
        while(i<=T.length-P.length+1){
            for(int j=0; j<P.length; j++){
                System.out.println(T[i+j] + "と" + P[j] + "の比較をする");
                count++;
                if(T[i+j] == P[j]){
                    if(j==P.length-1){
                        System.out.println("比較回数は " + count + "です。");
                        return i+1;
                    }
                }else{
                    break;
                }
            }

            // スキップ数の決定
            for(int k=0; k<length; k++){
                if(C[k] == T[i+P.length-1] || C[k] == ' '){
                    d = D[k];
                    break;
                }
            }

            i = i+d;
        }

        System.out.println("比較回数は " + count + "です。");
        return -1;
    }

    public static void returnTable(int[] array){
        System.out.print("スキップ数 : ");
        for(int i=0; i<array.length; i++){
            if(i==0){
                System.out.print(array[i]);
                continue;
            }
            System.out.print(", " + array[i]);
            if(i==array.length-1)
                System.out.print("\n");
        }
    }

    public static void returnTable(char[] array){
        System.out.print("判定文字   : ");
        for(int i=0; i<array.length; i++){
            if(i==0){
                System.out.print(array[i]);
                continue;
            }
            System.out.print(", " + array[i]);
            if(i==array.length-1)
                System.out.print("\n");
        }
    }

    public static int checkLength(char[] array){
        int result = array.length;
        int charCount = 0;
        int overlap = 0;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if(array[i] == array[j])
                    charCount++;
            }
            if(charCount > 1)
                overlap++;

                charCount = 0;
        }
        return result - overlap/2;
    }
}
