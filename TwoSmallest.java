public class TwoSmallest{

    public static int[] twoSmallest(int[] v, int i, int j){

        if(j-i<2)
            throw new RuntimeException("Expected at least 2 values, "+Integer.toString(j-i)+" found");

        if(j-i==2){
            if(v[i]>v[j-1]){
                int tmp = v[i];
                v[i] = v[j-1];
                v[j-1] = tmp;
            }
            int[] vOut = {v[i], v[j-1]};
            return vOut;
        }
        

        int[] v1 = twoSmallest(v, i, 1+(i+j)/2);
        
        int[] v2 = twoSmallest(v, (i+j)/2, j);
        int[] vOut = merge(v1, v2);
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
        int[] vOut = twoSmallest(vIn, 0, vIn.length);
        System.out.print("< ");
        for (int n : vOut){
            System.out.print(n+" ");
        }
        System.out.println(">");
    }
}