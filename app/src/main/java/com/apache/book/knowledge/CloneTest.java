package com.apache.book.knowledge;

/**
 * Created by 01370340 on 2018/11/18.
 */
public class CloneTest {

    public static void main(String[] args) {

        testLightCopy();
    }


    public static void testLightCopy(){

        People lpeople = new People();
        lpeople.name = "zhangsan";

        People rpeople = lpeople;
        rpeople.name = "lisi";
        System.out.println("lpeople = "+lpeople +" lpeople.name = "+lpeople.name +", rpeople = "+rpeople +" rpeople.name = "+rpeople.name  );

    }

    public static void testLightCopy2(){

        People lpeople = new People();
        lpeople.name = "zhangsan";
        lpeople.occupation = new People.Occupation();
        lpeople.occupation.company = "tencent";

        People rpeople = (People) lpeople.clone();
        rpeople.name = "lisi";
        rpeople.occupation.company = "baidu";
        System.out.println("lpeople = "+lpeople +" lpeople.name = "+lpeople.name +", rpeople = "+rpeople +" rpeople.name = "+rpeople.name  );


    }
}
