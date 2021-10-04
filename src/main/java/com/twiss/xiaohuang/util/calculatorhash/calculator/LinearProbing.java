package com.twiss.xiaohuang.util.calculatorhash.calculator;

import com.twiss.xiaohuang.util.calculatorhash.parameters.Parameters;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 线性探针
 * @Author: Twiss
 * @Date: 2021/10/3 11:52 上午
 */
public class LinearProbing extends AbstractCalculator {

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
            Double index = new CalculatorHashValue().calculatorIndex(variables, expression);
            while (resultHashIndex.containsKey(index)){
                index = index+1;
            }
            resultHashIndex.put(index,String.valueOf(x));
        }
        return resultHashIndex;
    }
}
