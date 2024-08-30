/*******************************************************************************
 * Copyright (c) 2019-2024 Institute for the Architecture of Application System - University of Stuttgart
 * Author: Ghareeb Falazi
 *
 * This program and the accompanying materials are made available under the
 * terms the Apache Software License 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 *******************************************************************************/
package blockchains.iaas.uni.stuttgart.de.api.utils;


import java.math.BigInteger;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class MathUtils {
    public static final double ACCEPTED_DOUBLE_ERROR = 0.000001;
    public static long factorial(int n) {
        return  CombinatoricsUtils.factorial(n);
    }

    public static int log2(BigInteger n) throws ArithmeticException {
        return n.bitLength();
    }

    public static int doubleCompare(double lhs, double rhs) {
        if (Math.abs(lhs-rhs) < ACCEPTED_DOUBLE_ERROR)
            return 0;
        if(lhs-rhs > ACCEPTED_DOUBLE_ERROR)
            return 1;
        return -1;
    }


}
