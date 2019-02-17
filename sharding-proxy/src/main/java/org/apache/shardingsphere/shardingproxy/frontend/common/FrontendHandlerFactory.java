/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.shardingproxy.frontend.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.core.constant.DatabaseType;
import org.apache.shardingsphere.shardingproxy.frontend.mysql.MySQLFrontendHandler;
import org.apache.shardingsphere.shardingproxy.frontend.postgresql.PostgreSQLFrontendHandler;

/**
 * Frontend handler factory.
 *
 * @author zhangliang
 * @author xiaoyu
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrontendHandlerFactory {
    
    /**
     * Create frontend handler instance.
     *
     * @param databaseType database type
     * @return frontend handler instance
     */
    public static FrontendHandler createFrontendHandlerInstance(final DatabaseType databaseType) {
        switch (databaseType) {
            case MySQL:
                return new MySQLFrontendHandler();
            case PostgreSQL:
                return new PostgreSQLFrontendHandler();
            default:
                throw new UnsupportedOperationException(String.format("Cannot support database type '%s'", databaseType));
        }
    }
}