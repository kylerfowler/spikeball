
/**
 * Write a description of class indexOf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class finder{
    //takes an array of strings and finds the index of a specific string 
    public static int indexOfString(String[] a, String target){
        for(int i = 0; i < a.length; i++){
            if (a[i].equals(target)){
                return i;
            }
        }
        return -1; 
    }
    //takes an array of integers and finds the index of a specific integer
    public static int indexOfInt(int[] a, int target){
        for(int i = 0; i < a.length; i++){
            if (a[i]==target){
                return i;
            }
        }
        return -1;
    }
}
        