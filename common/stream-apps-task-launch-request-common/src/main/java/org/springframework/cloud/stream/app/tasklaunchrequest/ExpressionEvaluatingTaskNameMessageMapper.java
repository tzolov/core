/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.app.tasklaunchrequest;

import org.springframework.cloud.stream.app.tasklaunchrequest.support.TaskNameMessageMapper;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.messaging.Message;

public class ExpressionEvaluatingTaskNameMessageMapper implements TaskNameMessageMapper {

    private final Expression expression;
    private final EvaluationContext evaluationContext;

    public ExpressionEvaluatingTaskNameMessageMapper(Expression expression, EvaluationContext evaluationContext) {
        this.evaluationContext = evaluationContext;
        this.expression = expression;
    }

    @Override
    public String processMessage(Message<?> message) {
        return expression.getValue(evaluationContext, message).toString();
    }
}
