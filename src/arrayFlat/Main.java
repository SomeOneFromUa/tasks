package arrayFlat;

import javax.print.attribute.Size2DSyntax;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> mainList = new ArrayList<>();
        mainList.add(1);
        mainList.add(2);
        mainList.add(3);
        mainList.add(4);
        ArrayList<Object> newList1 = new ArrayList<>();
        newList1.add(5);
        newList1.add(6);
        newList1.add(7);
        newList1.add(8);
        ArrayList<Object> newList2 = new
                ArrayList<>();
        newList2.add(9);
        newList2.add(10);
        newList2.add(11);
        newList1.add(newList2);
        mainList.add(newList1);


        Object[] objects = arrayFlat(mainList, '1');
        print(objects);

    }
    // for ArrayList
    public static ArrayList<Object> arrFlat(ArrayList<Object> arr, int level) {
        ArrayList<Object> res = new ArrayList<>();
        for (Object el : arr) {
            if (el.getClass().toString().equals("class java.util.ArrayList")) {
                if (level > 1) {
                    ArrayList<Object> processor = arrFlat((ArrayList<Object>) el, level - 1);
                    res.addAll(processor);
                } else res.add(el);

            } else res.add(el);
        }
        return res;
    }
// for vanilla java arrays (not working with more then one array on one level*)
    public static Object[] arrayFlat (ArrayList<Object> array, int level){
        Object[] arr = array.toArray(new Object[0]);
        Object[] res = new Object[20];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getClass().toString().equals("class java.util.ArrayList")) {
                if (level > 1) {
                    Object[] objects = arrayFlat((ArrayList<Object>) arr[i], level - 1);
                    System.arraycopy(objects, 0, res, i + 0, objects.length);
                } else res[i] = arr[i];
            } else res[i] = arr[i];
        }

        int count = 0;
        for (Object re : res) {
            if (re != null){
                count++;
            }
        }

        Object[] result = new Object[count];
        System.arraycopy(res, 0, result, 0, result.length);
        return result;
    }


    public static void print (Object[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Object o : arr) {
            stringBuilder.append(o).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-2)
                .deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
