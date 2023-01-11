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

@JsonRpcError(code = ExceptionCode.ReplaceRejectedError, message = "The specified invocation cannot be replaced")
public class ReplaceRejectedError extends BalException {

    public ReplaceRejectedError() {
        super();
    }

    public ReplaceRejectedError(String message) {
        super(message);
    }

    @Override
    public int getCode() {
        return ExceptionCode.ReplaceRejectedError;
    }
}
