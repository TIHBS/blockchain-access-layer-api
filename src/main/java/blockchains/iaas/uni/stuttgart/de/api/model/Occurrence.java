/*******************************************************************************
 * Copyright (c) 2019 Institute for the Architecture of Application System - University of Stuttgart
 * Author: Ghareeb Falazi
 *
 * This program and the accompanying materials are made available under the
 * terms the Apache Software License 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 *******************************************************************************/

package blockchains.iaas.uni.stuttgart.de.api.model;

import blockchains.iaas.uni.stuttgart.de.api.utils.TimeUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Occurrence {
    List<Parameter> parameters;
    String isoTimestamp;

    @JsonIgnore
    public LocalDateTime getTimestampObject() {
        return TimeUtils.getTimestampObject(isoTimestamp);
    }
}
