package jvm小册.class文件结构;

import java.util.ArrayList;
import java.util.List;

/**
 *  #5 = InterfaceMethodref #29.#30        // java/util/List.add:(Ljava/lang/Object;)Z
 *     #29 = Class              #36            // java/util/List
 *   #30 = NameAndType        #37:#38        // add:(Ljava/lang/Object;)Z
 */
public class InterfaceMethodRefInfo {

        public static void main(String[] args) {

            List<Integer> list = new ArrayList<>();
            list.add(1);
    }
}
