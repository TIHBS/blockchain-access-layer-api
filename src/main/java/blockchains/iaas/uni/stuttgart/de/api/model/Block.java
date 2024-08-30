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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@XmlRootElement(name = "Block")
@XmlAccessorType(XmlAccessType.NONE)
public class Block {
    @Getter
    private BigInteger number;
    private String hash;

    public Block() {

    }

    public Block(BigInteger number, String hash) {
        this.number = number;
        this.hash = hash;
    }

    @XmlElement(name = "BlockNumber")
    public long getNumberAsLong() {
        return this.number.longValue();
    }

    public void setNumberAsLong(long value) {
        this.number = BigInteger.valueOf(value);
    }

    @XmlElement(name = "BlockHash")
    public String getHash() {
        return hash;
    }
}
