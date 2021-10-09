package com.twiss.xiaohuang.util.calculatorhash.calculator;

import com.twiss.xiaohuang.util.calculatorhash.parameters.Parameters;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 二次探针
 *
 * @Author: Twiss
 * @Date: 2021/10/3 12:19 下午
 */
public class QuadraticProbing extends AbstractCalculator {

    @Override
    protected Map<Double,String> getIndexMap(Parameters parameters) throws Exception {
        Map<Double,String> resultHashIndex = new LinkedHashMap<>();
        int[] array = parameters.getNums();
        int m = parameters.getM();
        String expression = parameters.getExpression();
        Map<String,Integer> variables = new LinkedHashMap<>();
        // 设置阿尔法值
        variables.put("m",m);
        for (int x : array) {
            // 设置k值
            variables.put("x",x);
            int i = 0;
            // 设置i值
            variables.put("i",i);
            Double index = new CalculatorHashValue().calculatorIndex(variables, expression);
            while (resultHashIndex.containsKey(index)) {
                i++;
                variables.put("i",i);
                index = new CalculatorHashValue().calculatorIndex(variables, expression);
            }
            resultHashIndex.put(index,String.format("%s", x));
        }
        return resultHashIndex;
    }
}
