/********************************************************************************
 * Copyright (c) 2018-2024 Institute for the Architecture of Application System -
 * University of Stuttgart
 * Author: Ghareeb Falazi
 *
 * This program and the accompanying materials are made available under the
 * terms the Apache Software License 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/
package blockchains.iaas.uni.stuttgart.de.api.model;


import java.math.BigInteger;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@XmlRootElement(name="Transaction")
@XmlAccessorType(XmlAccessType.NONE)
public class LinearChainTransaction extends Transaction {

    @XmlElement(name="TransactionHash")
    private String transactionHash;

    @XmlElement
    private Block block;

    @XmlElement(name="From")
    private String from;

    @XmlElement(name="To")
    private String to;

    private BigInteger value;

    public LinearChainTransaction() {
        super();
    }

    public LinearChainTransaction(String transactionHash,
                                  Block block,
                                  String from, String to, BigInteger value, TransactionState state, List<Parameter> returnValues) {
        this.setReturnValues(returnValues);
        this.setState(state);
        this.transactionHash = transactionHash;
        this.block = block;
        this.from = from;
        this.to = to;
        this.value = value;
    }

    @XmlElement(name="Value")
    public String getValueAsString(){
        return value.toString();
    }

    public void setValueAsString(String value){
        this.value = new BigInteger(value);
    }
}
