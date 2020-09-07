package arrayFlat;

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
        ArrayList<Object> newList3 = new
                ArrayList<>();
        newList3.add(12);
        newList3.add(13);
        newList3.add(14);
        ArrayList<Object> newList4 = new
                ArrayList<>();
        newList4.add(15);
        newList4.add(16);
        newList4.add(17);
        newList3.add(newList4);
        newList1.add(newList2);
        newList1.add(newList3);
        mainList.add(newList1);
        ArrayList<Object> flatted = arrFlat(mainList, 1);
        System.out.println(flatted);
        ArrayList<Object> flatted2 = arrFlat(mainList, 2);
        System.out.println(flatted2);
        ArrayList<Object> flatted3 = arrFlat(mainList, 3);
        System.out.println(flatted3);
        ArrayList<Object> flatted4 = arrFlat(mainList, 4);
        System.out.println(flatted4);

    }
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
}
