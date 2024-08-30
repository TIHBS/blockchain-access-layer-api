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

import blockchains.iaas.uni.stuttgart.de.api.interfaces.FinalityConfidenceCalculator;
import blockchains.iaas.uni.stuttgart.de.api.model.LinearChainTransaction;
import lombok.Getter;
import lombok.Setter;

@Getter
public class PoWConfidenceCalculator implements FinalityConfidenceCalculator {
    @Setter
    private long currentBlockchainHeight;
    private double adversaryRatio;

    public void setAdversaryRatio(double adversaryRatio) {
        if (adversaryRatio >= 0.0 && adversaryRatio <= 1.0) {
            this.adversaryRatio = adversaryRatio;
        } else {
            throw new IllegalArgumentException("Adversary ratio must be between 0.0 and 1.0!");
        }
    }

    /**
     * Uses the equation from the Bitcoin whitepaper to calculate the degree-of-confidence
     *
     * @param transaction the transaction to calculate the current confidence for.
     * @return the current DoC measured between 0.0 and 1.0
     */
    @Override
    public double getCurrentConfidence(LinearChainTransaction transaction) {
        final long z = this.currentBlockchainHeight - transaction.getBlock().getNumberAsLong();
        return this.getConfidence(z);
    }

    public long getEquivalentBlockDepth(double requiredConfidence) {
        long z = 0;
        double currentConfidence = 0.0;

        while (currentConfidence < requiredConfidence) {
            currentConfidence = getConfidence(z);
            ++z;
        }

        return z;
    }

    private double getConfidence(long z) {
        final double q = this.adversaryRatio;

        if (z < 0.0) {
            throw new RuntimeException("currentBlockchainHeight is smaller than the block height of the transaction!");
        }

        final double lambda = z * (q / (1 - q));
        double accumulator = 0.0;
        double part1;
        double part2;

        for (int k = 0; k < z; k++) {
            part1 = (Math.pow(lambda, k) * Math.exp(-lambda)) / MathUtils.factorial(k);
            part2 = 1 - Math.pow(q / (1 - q), z - k);
            accumulator += part1 * part2;
        }

        return accumulator;
    }
}
