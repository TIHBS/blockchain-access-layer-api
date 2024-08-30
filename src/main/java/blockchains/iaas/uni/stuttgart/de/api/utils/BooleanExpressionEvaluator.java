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

import blockchains.iaas.uni.stuttgart.de.api.model.Parameter;
import lombok.extern.log4j.Log4j2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

@Log4j2
public class BooleanExpressionEvaluator {

    public static boolean evaluate(String expression, List<Parameter> parameters) throws Exception {
        if (expression == null || expression.isEmpty()) {
            return true;
        }
        
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine jsEngine = mgr.getEngineByName("graal.js");
        log.info("Available script engines: {}", new ScriptEngineManager().getEngineFactories());

        for (Parameter param : parameters) {
            jsEngine.put(param.getName(), JsonSchemaToJavaTypeMapper.map(param));
        }

        log.info("Executing in script environment...");

        try {
            Object result = jsEngine.eval(expression);
            if (result instanceof Boolean) {
                return (Boolean) result;
            } else {
                throw new RuntimeException(String.format("The expression evaluated to type: %s, but a boolean value was expected!", result.getClass().getName()));
            }
        } catch (ScriptException ex) {
            log.error("Failed to execute boolean expression {}. Reason: {}.", expression, ex.getMessage());
            throw ex;
        }
    }
}
