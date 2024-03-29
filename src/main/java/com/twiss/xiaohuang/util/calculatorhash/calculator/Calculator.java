package com.twiss.xiaohuang.util.calculatorhash.calculator;

import com.twiss.xiaohuang.util.calculatorhash.parameters.Parameters;

import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/10/3 11:42 上午
 */
public interface Calculator {

    /**
     * 计算哈希表index
     * @return
     * @throws Exception
     */
    Map<Double,String> execute(Parameters parameters) throws Exception;
}
