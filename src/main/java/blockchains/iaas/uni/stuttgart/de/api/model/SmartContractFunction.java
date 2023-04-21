/*******************************************************************************
 * Copyright (c) 2023 Institute for the Architecture of Application System - University of Stuttgart
 * Author: Ghareeb Falazi
 *
 * This program and the accompanying materials are made available under the
 * terms the Apache Software License 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 *******************************************************************************/
package blockchains.iaas.uni.stuttgart.de.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="SmartContract")
public class SmartContractFunction {
    String functionIdentifier;
    List<Parameter> inputs;
    List<Parameter> outputs;
}
