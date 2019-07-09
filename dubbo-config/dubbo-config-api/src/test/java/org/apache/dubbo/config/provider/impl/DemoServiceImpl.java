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
package org.apache.dubbo.config.provider.impl;

import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.config.api.Box;
import org.apache.dubbo.config.api.DemoException;
import org.apache.dubbo.config.api.DemoService;
import org.apache.dubbo.config.api.User;
import org.apache.dubbo.rpc.RpcContext;

import java.util.List;

import static java.lang.String.format;

/**
 * DemoServiceImpl
 */
public class DemoServiceImpl implements DemoService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String sayName(String name) {
        return log("say:" + name);
    }

    public Box getBox() {
        return null;
    }

    public void throwDemoException() throws DemoException {
        throw new DemoException("DemoServiceImpl");
    }

    public List<User> getUsers(List<User> users) {
        return users;
    }

    public int echo(int i) {
        return i;
    }

    private <T> T log(T object) {
        RpcContext rpcContext = RpcContext.getContext();
        logger.info(format("RPC Invocation [ client - %s:%s , provider - %s:%s] : %s",
                rpcContext.getRemoteHost(), rpcContext.getRemotePort(),
                rpcContext.getLocalHost(), rpcContext.getLocalPort(),
                object));
        return object;
    }
}