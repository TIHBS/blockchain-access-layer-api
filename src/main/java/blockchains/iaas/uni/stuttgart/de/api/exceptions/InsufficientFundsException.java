/********************************************************************************
 * Copyright (c) 2023 Institute for the Architecture of Application System -
 * University of Stuttgart
 * Author: Akshay Patel
 *
 * This program and the accompanying materials are made available under the
 * terms the Apache Software License 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/
package blockchains.iaas.uni.stuttgart.de.api.exceptions;

import com.github.arteam.simplejsonrpc.core.annotation.JsonRpcError;

@JsonRpcError(code = ExceptionCode.InsufficientFunds, message = "Not enough funds to invoke the state-changing\n" +
        "smart contract function.")
public class InsufficientFundsException extends BalException {

    public InsufficientFundsException() {
        super();
    }

    public InsufficientFundsException(String message) {
        super(message);
    }

    @Override
    public int getCode() {
        return ExceptionCode.InsufficientFunds;
    }
}
