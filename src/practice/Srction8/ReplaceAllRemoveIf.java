package practice.Srction8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceAllRemoveIf {
        public static void main(String[] args) {
            List<String> mutable = new ArrayList<>(Arrays.asList("jammu", "ludhiana", "jalandhar", "himachal", "chennai"));

            mutable.replaceAll(x->x.toUpperCase());
            System.out.println(mutable);

            mutable.removeIf(x->x.length() >8);
            System.out.println(mutable);
        }

    }

