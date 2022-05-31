public class TwoSmallest{

    public static int[] twoSmallest(int[] v){

        int l = v.length;

        if(l<2)
            throw new RuntimeException("Expected at least 2 values, "+ l +" found");

        if(l==2){
            if(v[0]>v[1]){
                int tmp = v[0];
                v[0] = v[1];
                v[1] = tmp;
            }
            return v;
        }
        
        int offset;
        if(l%2 == 0)
            offset = 0;
        else
            offset = 1;

        int[] v1 = new int[l/2+offset];
        int[] v2 = new int[l/2+offset]; 

        for(int i=0; i<l/2+offset; i++){
            v1[i] = v[i];
            v2[i] = v[i+l/2];
        }

        int[] vOut = merge(twoSmallest(v1), twoSmallest(v2));
        return vOut;
    }

    public static int[] merge(int[] v1, int[] v2){
        int i = 0;
        int j = 0;
        int vOut[] = new int[2];
        int k = 0;
        while(k<2){
            if(v1[i]<v2[j])
                vOut[k++] = v1[i++];
            else
                vOut[k++] = v2[j++];
        }
        return vOut;
    }

    public static void main(String args[]){
        int[] vIn = {3, 1, 7, 5, 0, 4, 9, 6, 8, -5};
        int[] vOut = twoSmallest(vIn);
        System.out.print("< ");
        for (int n : vOut){
            System.out.print(n+" ");
        }
        System.out.println(">");
    }
}