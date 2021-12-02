package com.twiss.xiaohuang.util.calculatorhash;

import com.twiss.xiaohuang.util.common.CommonUtil;
import com.twiss.xiaohuang.util.calculatorhash.calculator.CalculatorFactory;
import com.twiss.xiaohuang.util.calculatorhash.parameters.Parameters;

import java.util.Map;

/**
 * 用户
 * @Author: Twiss
 * @Date: 2021/10/3 10:26 上午
 */
public class UserOperation {

    public static void main(String[] args) throws Exception {
        CommonUtil commonUtil = new CommonUtil();
        // Quadratic
        int[] arrays = {88,  97,  39,  158};
        int alpha = 7;
        String expression = "((x % m) +i + i^2) % m";
        Integer type = 2;
        Parameters parameters = new Parameters(arrays,alpha,expression);
        Map<Double,String> res = new CalculatorFactory().hashTableMap(type,parameters);
        System.out.println("Quadratic: ");
        System.out.println(commonUtil.jsonFormat(res));

        // Linear
//        int[] arrays2 = {9,12,14,3,4,21,18};
        int[] arrays2 = {91, 123, 13, 62};
        int alpha2 = 7;
        Integer type2 = 1;
        String expression2 = "x % m";
        Parameters parameters2 = new Parameters(arrays2,alpha2,expression2);
        Map<Double,String> res2 = new CalculatorFactory().hashTableMap(type2,parameters2);
        System.out.println("Linear: ");
        System.out.println(commonUtil.jsonFormat(res2));

        // Chaining
        int[] arrays3 = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        int alpha3 = 11;
        int type3 = 3;
        String expression3 = "(2*x+5)%m";
        Parameters parameters3 = new Parameters(arrays3,alpha3,expression3);
        Map<Double,String> res3 = new CalculatorFactory().hashTableMap(type3,parameters3);
        System.out.println("Chaining: ");
        System.out.println(commonUtil.jsonFormat(res3));
    }
}