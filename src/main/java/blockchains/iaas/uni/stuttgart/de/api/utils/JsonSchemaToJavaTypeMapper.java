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

import blockchains.iaas.uni.stuttgart.de.api.exceptions.BalException;
import blockchains.iaas.uni.stuttgart.de.api.exceptions.ParameterException;
import blockchains.iaas.uni.stuttgart.de.api.model.Parameter;
import jakarta.xml.bind.DatatypeConverter;

import jakarta.json.JsonObject;
import jakarta.json.Json;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class JsonSchemaToJavaTypeMapper {

    public static Object map(Parameter parameter) throws BalException {
        try {
            JsonObject jsonObject = Json.createReader(new ByteArrayInputStream(parameter.getType().getBytes())).readObject();

            return map(jsonObject, parameter.getValue());
        } catch (Exception e) {
            if (!(e instanceof BalException))
                throw new ParameterException(e.getMessage());

            throw (BalException) e;
        }
    }

    private static Object map(JsonObject jsonObject, String value) {

        String type = jsonObject.getString("type");

        switch (type) {
            case "boolean" -> {
                return Boolean.parseBoolean(value);
            }
            case "string" -> {
                if (jsonObject.containsKey("pattern") && jsonObject.getString("pattern").equals("^[a-fA-F0-9]{2}$")) {
                    byte[] bytes = DatatypeConverter.parseHexBinary(value);

                    if (bytes.length == 1) {
                        return bytes[0];
                    }

                    throw new ParameterException("Invalid byte array: " + value);
                }

                return value;
            }
            case "integer" -> {
                return Long.parseLong(value);
            }
            case "number" -> {
                return Double.parseDouble(value);
            }
            case "array" -> {
                return handleArrayType(jsonObject, value);
            }
        }

        throw new ParameterException("Unrecognized type!");
    }

    // todo this will not work with ethereum byte array types!
    private static Object handleArrayType(JsonObject outerJsonObject, String value) {
        if (outerJsonObject.containsKey("items")) {
            // get the "items" schema, tuples are not yet supported!
            JsonObject jsonObject = outerJsonObject.getJsonObject("items");

            // not an empty array!
            if (value.length() > 2) {
                String[] values = value.substring(1, value.length() - 1).split(",");

                return Arrays.stream(values).map(current -> map(jsonObject, current)).toArray();
            }
        }

        throw new ParameterException("Unrecognized array type!");
    }
}
